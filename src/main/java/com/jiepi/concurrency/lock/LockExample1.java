package com.jiepi.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample1 {


    private static final int clientTotal = 5000;

    private static final int threadTotal = 200;

    private static int count = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);

        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {

            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();

                } catch (Exception e) {

                }
                countDownLatch.countDown();
            });

        }
        log.info("count:{}", count);
        countDownLatch.await();
        executorService.shutdown();


    }


    private static void update() {
        lock.lock();
        try {
            count++;

        } finally {
            lock.unlock();
        }

    }
}
