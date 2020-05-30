package com.threadTest;

import java.util.Date;

public class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println("myThread is runnning" + new Date().getTime());
        }


    }
}

class test {
    public static void main(String[] args) {
        new MyThread().start();
    }
}
