package com.fslt.mycloudserver.modules.aqs.test;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @description: MyLockTest
 * @date: 2020/5/13 9:28
 * @author: 林宗雄
 * @version: 1.0
 */
class MyLockTest {

    @Test
    void lock() {
    }

    @Test
    void unLock() {
    }

    @Test
    void testLockAndUnLock() throws InterruptedException {

        IntStream.range(0, 3).mapToObj(i -> new Thread(() -> myBizMethod())).forEach(t -> t.start());
        Thread.currentThread().join(10000);

    }

    MyLock myLock = new MyLock();

    private void myBizMethod() {
        try {
            myLock.lock();
            String t = Thread.currentThread().getName();
            IntStream.range(0, 5).forEach(i -> System.out.println("线程：" + t + ",index：" + i));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myLock.unLock();
        }
    }

}