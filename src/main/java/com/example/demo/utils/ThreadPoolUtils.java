package com.example.demo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final  class ThreadPoolUtils {

    public static ExecutorService getThreadPool(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService;
    }


}
