package com.jiepi.concurrency.dateFormate;

import com.jiepi.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

//import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class DateFormate {

    private static final int clientTotal = 5000;

    private static final int threadTotal = 200;

//    private static org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");
//   private  static  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            });
            countDownLatch.countDown();
        }

        countDownLatch.await();
        executorService.shutdown();

    }

    public static void update() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        System.out.println(DateTime.parse("20180909", dateTimeFormatter).toDate());
      try {
          System.out.println(simpleDateFormat.parse("20180909"));
      }catch (Exception e){
          log.error("eeeeeeeeeeee{}",e);
      }

    }

}
