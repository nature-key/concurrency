package com.jiepi.concurrency.singleton;


import com.jiepi.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式  在第一次进行初始化
 */
@NotThreadSafe
public class SingletonExample3 {

    /**
     * 1.私有构造函数
     */
    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    /**
     * 静态工厂方法
     * @return
     *
     *
     *
     */
    public static  SingletonExample3 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample3.class) {//同步锁
                if (instance ==null) {
                    /**
                     * 1.分配内存空间
                     * 2，初始化
                     * 3.instance 只想刚才分配的没存地址
                     */
                    instance = new SingletonExample3();
                }
            }
        }
        return instance;
    }


}
