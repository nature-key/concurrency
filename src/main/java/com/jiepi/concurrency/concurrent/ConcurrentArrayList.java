package com.jiepi.concurrency.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ConcurrentArrayList {


    private static List list = new CopyOnWriteArrayList();
    private static final int clientTotal = 5000;

    private static final int threadTotal = 200;

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);

        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = 0;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();

                } catch (Exception e) {

                }
                countDownLatch.countDown();
            });

        }
        log.info("size:{}", list.size());
        countDownLatch.await();
        executorService.shutdown();


    }


    private static void update(int i) {
        list.add(i);
    }
}
