package com.jiepi.concurrency.Atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class AtomicExample3 {
        //智只会执行一次
    private static AtomicBoolean isHappen = new AtomicBoolean();

    public static int clientThread =5000;

    public static int threadTotla=200;
    public static void main(String[] args) throws  Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotla);

        final CountDownLatch countDownLatch = new CountDownLatch(clientThread);

        for (int i = 0; i < clientThread; i++) {
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    test();
                    semaphore.release();
                }catch (Exception e){
                    log.error("fail:{}",e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",isHappen.get());
    }


    private static void test(){
        if (isHappen.compareAndSet(false,true)) {
            log.info("execuct");
        }
    }
}
