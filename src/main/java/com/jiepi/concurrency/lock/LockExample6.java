package com.jiepi.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample6 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(()->{
            try {
                reentrantLock.lock(); //获取锁
                 log.info("wait signal");
                 condition.await(); //释放锁 当到条件等待对列
            }catch (Exception e){
                e.getStackTrace();
            }
            log.info("get signal");
            reentrantLock.unlock();//线程一释放锁

        }).start();

        new Thread(()->{
            reentrantLock.lock();//线程二 获取锁 ，放在对列中
            log.info("get local");

            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.getStackTrace();
            }
            condition.signalAll();//发送信号唤醒条件里面的线程
            log.info("send signak+===");
            reentrantLock.unlock();//释放锁  目前只有线程一

        }).start();
    }
}
