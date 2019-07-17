package com.jiepi.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchizedExample2 {

    /**
     * 作用于所有对象
     */
    private void test1() {

        synchronized (SynchizedExample2.class) {

            for (int i = 0; i < 10; i++) {
                log.info("test1{} {}", 1, i);
            }
        }

    }

    private static synchronized void test2(){
        for (int i = 0; i <10 ; i++) {
            log.info("test2{} {}",2,i);
        }

    }


    public static void main(String[] args) {
        SynchizedExample2 synchizedExample1 = new SynchizedExample2();
        SynchizedExample2 synchizedExample2 = new SynchizedExample2();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
             synchizedExample1.test1();
        });

        executorService.execute(()->{
            synchizedExample2.test1();
        });

    }




}
