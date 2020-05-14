package com.fslt.mycloudserver.modules.aqs.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description: MyUnSafe
 * @date: 2020/5/14 9:12
 * @author: 林宗雄
 * @version: 1.0
 */
public class MyUnSafe {

    public static Unsafe unsafe;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
