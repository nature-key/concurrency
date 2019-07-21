package com.jiepi.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
@Slf4j
public class ForkjoinExample  extends RecursiveTask<Integer>{

    public  static  final  int thredaHold =2;

    private  int start;
    private int end;

    public ForkjoinExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum =0;
        Boolean canComputer = end-start<=thredaHold;
        if (canComputer) {
            for (int i = start; i <= end; i++) {
                 sum+=i;
            }
        }else {
            int middle =(end+start)/2;
            ForkjoinExample  leftforkjoinExample = new ForkjoinExample(start,middle);
            ForkjoinExample  rightforkjoinExample = new ForkjoinExample(middle+1,end);

            leftforkjoinExample.fork();
            rightforkjoinExample.fork();



           int leftResutl =  leftforkjoinExample.join();
           int rightResult = rightforkjoinExample.join();

           sum = leftResutl+rightResult;


        }

        return  sum;


    }


    public static void main(String[] args) throws  Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkjoinExample forkjoinExample = new ForkjoinExample(1,100);
       Future<Integer> result = forkJoinPool.submit(forkjoinExample);

        int sum = result.get();

        log.info("sum:{}",sum);


    }
}
