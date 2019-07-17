package com.jiepi.concurrency.Atomic;

import com.jiepi.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample2 {

    private static AtomicIntegerFieldUpdater<AtomicExample2> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample2.class, "count");
    //必录olatitla
    @Getter
    public volatile int count = 100;
    private  static  AtomicExample2 example2 = new AtomicExample2();
    public static void main(String[] args) {
        if(updater.compareAndSet(example2,100,120)){
            log.info("success{}",example2.getCount());
        }

        if (updater.compareAndSet(example2,100,120)) {
            log.info("update success{}",example2.getCount());
        }else{
            log.info("fail{}",example2.getCount());
        }

    }
}
