package com.threadTest;

public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+ "->" + Thread.currentThread().getPriority());
        TestThread priority = new TestThread();
        Thread t1 = new Thread(priority,"No.1");
        Thread t2 = new Thread(priority,"No.2");
        Thread t3 = new Thread(priority,"No.3");
        Thread t4 = new Thread(priority,"No.4");
        Thread t5 = new Thread(priority,"No.5");


        t1.start(); //默认是5

        t2.setPriority(3);
        t2.start();

        t3.setPriority(5);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

    }
}

class TestThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ==> " + Thread.currentThread().getPriority());
    }
}
