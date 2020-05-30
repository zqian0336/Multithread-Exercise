package com.threadTest;

public class MyJoin implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("thread is " + i );
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyJoin m = new MyJoin();
       Thread t = new Thread(m);
       t.start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) t.join(); //原来争抢，后来插队
            System.out.println("Main is "+i);
        }
    }
}
