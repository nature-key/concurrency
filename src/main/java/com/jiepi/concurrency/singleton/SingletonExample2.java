package com.jiepi.concurrency.singleton;


import com.jiepi.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式  在第一次进行初始化
 */
@NotThreadSafe
public class SingletonExample2 {

    /**
     * 1.私有构造函数
     */
    private SingletonExample2() {

    }

    private static SingletonExample2 instance = null;

    /**
     * 静态工厂方法  Synchroized
     * @return
     */
    public static synchronized SingletonExample2 getInstance() {
        if (instance == null) {
            instance = new SingletonExample2();
        }
        return instance;
    }


}
