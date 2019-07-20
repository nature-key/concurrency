package com.jiepi.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExeample1 {

    private final static int threadTotal = 200;

    /**
     * 当对列的计数为零的时候才会进行下面的执行
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for (int i = 0; i < threadTotal; i++) {
            final int num = i;
            exec.execute(() -> {
                try {
                    test(num);
                } catch (Exception e) {
                    log.error("error {}", e.getCause());
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finish");
        exec.shutdown();


    }

    private static void test(int num) throws Exception {
        Thread.sleep(100);
        log.info("num:{}", num);
    }


}
