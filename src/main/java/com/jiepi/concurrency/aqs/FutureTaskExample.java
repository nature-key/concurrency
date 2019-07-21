package com.jiepi.concurrency.aqs;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskExample {


    public static void main(String[] args) throws  Exception {
        FutureTask<String> task = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                log.info("do some  thing");
                Thread.sleep(2000);
                return "done";
            }
        });

        new Thread(task).start();
        log.info("do something in main");
        Thread.sleep(1000);
       String result =  task.get();
       log.info("result: {}",result);

    }
}
