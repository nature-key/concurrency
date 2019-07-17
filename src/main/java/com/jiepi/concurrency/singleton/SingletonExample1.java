package com.jiepi.concurrency.singleton;


import com.jiepi.concurrency.annoations.NotThreadSafe;

/**
 * 恶汉模式  在初始化加载
 *    线程安全
 *     l浪费资源
 */

public class SingletonExample1 {

    /**
     * 1.私有构造函数
     */
    private SingletonExample1() {

    }

    private static SingletonExample1 instance = new SingletonExample1();

    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample1 getInstance() {
        return instance;
    }


}
