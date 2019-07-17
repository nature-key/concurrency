package com.jiepi.concurrency.singleton;


/**
 * 恶汉模式  在初始化加载
 *    线程安全
 *     l浪费资源
 */

public class SingletonExample5 {

    /**
     * 1.私有构造函数
     */
    private SingletonExample5() {

    }

    private static SingletonExample5 instance = null;

    static {
        instance = new SingletonExample5();
    }

    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample5 getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(instance);
        System.out.println(instance);
    }

}
