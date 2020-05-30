package com.threadTest;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "is running");
        }

    }
}
class test2 {
    public static void main(String[] args) {
        MyRunnable m = new MyRunnable();
        new Thread(m, "No1").start();
        new Thread(m, "No2").start();
    }
}
