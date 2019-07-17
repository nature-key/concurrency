package com.jiepi.concurrency.sync;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchizedExample1 {

    /**
     * 作用于所有调用对象
     */
    private void test1() {

        synchronized (this) {

            for (int i = 0; i < 10; i++) {
                log.info("test1{} {}", 1, i);
            }
        }

    }

    private synchronized void test2(){
        for (int i = 0; i <10 ; i++) {
            log.info("test2====={} ----{}",2,i);
        }

    }


    public static void main(String[] args) {
        SynchizedExample1 synchizedExample1 = new SynchizedExample1();
        SynchizedExample1 synchizedExample2 = new SynchizedExample1();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
             synchizedExample1.test2();
        });

        executorService.execute(()->{
            synchizedExample2.test1();
        });

    }




}
