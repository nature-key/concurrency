package com.jiepi.concurrency.singleton;


import com.jiepi.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式  在第一次进行初始化
 */
@NotThreadSafe
public class SingletonExample4 {

    /**
     * 1.私有构造函数
     */
    private SingletonExample4() {

    }
   // j禁止重排序
    private static volatile SingletonExample4 instance = null;

    /**
     * 静态工厂方法
     * @return
     *
     *
     *
     */
    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {//同步锁
                if (instance ==null) {
                    /**
                     * 1.分配内存空间
                     * 2，初始化
                     * 3.instance 只想刚才分配的没存地址
                     */
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }


}
