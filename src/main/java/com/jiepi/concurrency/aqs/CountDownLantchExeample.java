package com.jiepi.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CountDownLantchExeample {

    private final static int threadTotal = 20;

    /**
     * 当对列的计数为零的时候才会进行下面的执行
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < threadTotal; i++) {
            final int num = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    test(num);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("error {}", e.getCause());
                } finally {
                }
            });
        }
        log.info("finish");
        exec.shutdown();


    }

    private static void test(int num) throws Exception {
        Thread.sleep(1000);
        log.info("num:{}", num);
    }


}
