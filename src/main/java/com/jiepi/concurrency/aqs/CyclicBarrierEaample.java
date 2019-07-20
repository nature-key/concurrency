package com.jiepi.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j

public class CyclicBarrierEaample {

    private  final static CyclicBarrier barrier = new CyclicBarrier(5);
    public static void main(String[] args)  throws  Exception{
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final  int num =i;
            Thread.sleep(1000);
            exec.execute(()->{
                 try {
                     test(num);
                 }catch (Exception e){
                     log.error("error:{}",e);
                 }

             });
        }
    }

    public  static  void test(int num) throws  Exception{
        log.info("{} is ready",num);
        Thread.sleep(1000);
        barrier.await();
        log.info("{} is coubtinue",num);

    }
}
