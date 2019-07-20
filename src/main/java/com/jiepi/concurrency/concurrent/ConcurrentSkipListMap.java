package com.jiepi.concurrency.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.*;

@Slf4j
public class ConcurrentSkipListMap {

   //treeset
    private static Set set = new ConcurrentSkipListSet();
    private static final int clientTotal = 5000;

    private static final int threadTotal = 200;

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);

        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
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
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", set.size());


    }


    private static void update(int i) {
        set.add(i);
    }
}
