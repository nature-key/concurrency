package com.jiepi.concurrency.threadLocal;

public class RequestHolder {

    private static final  ThreadLocal<Long>  thread = new ThreadLocal<>();


    public static void add(Long id){
        thread.set(id);
    }

    public static String getId(){

        return thread.get().toString();
    }

    public static void remove(){
        thread.remove();
    }

}
