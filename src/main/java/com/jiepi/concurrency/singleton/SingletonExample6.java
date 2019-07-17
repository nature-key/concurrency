package com.jiepi.concurrency.singleton;


/**
 * 恶汉模式  在初始化加载
 *    线程安全
 *     l浪费资源
 */

public class SingletonExample6 {

    /**
     * 1.私有构造函数
     */
    private SingletonExample6() {

    }



    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample6 getInstance() {

        return Singleton.INSTANCE.getSingletonExample6();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample6 singletonExample6;
        //jvm 保证只执行一次
        Singleton(){
            singletonExample6 = new SingletonExample6();
        }

        public SingletonExample6 getSingletonExample6() {
            return singletonExample6;
        }
    }


    public static void main(String[] args) {
        System.out.println(SingletonExample6.getInstance());
        System.out.println(SingletonExample6.getInstance());
//        System.out.println(instance);
    }

}
