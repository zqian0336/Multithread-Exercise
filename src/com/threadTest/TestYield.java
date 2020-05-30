package com.threadTest;

public class TestYield {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my, "No.1").start();
        new Thread(my, "No.2").start();
    }

}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "stopped");
    }
}
