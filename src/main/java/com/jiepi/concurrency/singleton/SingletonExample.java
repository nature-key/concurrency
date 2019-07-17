package com.jiepi.concurrency.singleton;


import com.jiepi.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式  在第一次进行初始化
 */
@NotThreadSafe
public class SingletonExample {

    /**
     * 1.私有构造函数
     */
    private SingletonExample() {

    }

    private static SingletonExample instance = null;

    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }


}
