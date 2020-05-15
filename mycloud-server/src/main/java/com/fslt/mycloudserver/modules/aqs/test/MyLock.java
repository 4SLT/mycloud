package com.fslt.mycloudserver.modules.aqs.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: MyLock
 * @date: 2020/5/13 9:21
 * @author: 林宗雄
 * @version: 1.0
 */
public class MyLock {

    private static Unsafe unsafe;
    /**
     * 判断是否加锁标识（未加锁：0 已加锁：1）
     */
    private volatile int state;
    private static long stateOffset;

    private static ConcurrentHashMap<String, Thread> concurrentHashMap;

    private static ThreadLink threadLink;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            stateOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state"));

            concurrentHashMap = new ConcurrentHashMap();
            threadLink = new ThreadLink();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加锁
     * 挂起线程的时候需要放入容器中，才能在解锁时获取已挂起的线程
     */
    public void lock() {
        while (true) {
            //通过o(当前对象)加上offset(偏移量地址)，定位到底层中对应的值，然后把这个值和i进行比，如果一样，就更新底层中对应的值为i1
                if (MyUnSafe.unsafe.compareAndSwapInt(this, stateOffset, 0, 1)) {
                System.out.println("线程：" + Thread.currentThread().getName() + "获得了锁");
                break;
            } else {
//                concurrentHashMap.put(Thread.currentThread().getName(), Thread.currentThread());
//                //挂起线程
//                unsafe.park(false, 0);

                threadLink.addWaiter();
                MyUnSafe.unsafe.park(false, 0);

            }
        }
    }


    /**
     * 解锁
     */
    public void unLock() {
//        //重置标志位
//        unsafe.compareAndSwapInt(this, stateOffset, 1, 0);
//        //恢复挂起线程
//        for (Map.Entry<String, Thread> entry : concurrentHashMap.entrySet()) {
//            unsafe.unpark(entry.getValue());
//            concurrentHashMap.remove(entry.getKey());
//        }

        MyUnSafe.unsafe.compareAndSwapInt(this, stateOffset, 1, 0);
        threadLink.release();

    }

}
