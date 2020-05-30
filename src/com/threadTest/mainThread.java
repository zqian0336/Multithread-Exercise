package com.threadTest;

import java.util.Date;

public class mainThread {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();

        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        t.start();
        for(int i = 0 ; i <  100  ; i++){
            System.out.println("main is running");
        }

    }
}
