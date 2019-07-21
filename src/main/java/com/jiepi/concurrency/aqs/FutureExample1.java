package com.jiepi.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class FutureExample1 {

    static class Myfuture implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info("do some  thing");
            Thread.sleep(5000);
            return "done";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Myfuture());
        log.info("in main do sometHING");
        Thread.sleep(1000);
        String result = future.get();
        log.info("main {}", result);


    }
}
