package com.threadTest;

//Sleep Exercise
public class CountDown implements Runnable {

    private int count = 10;

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count--);
            if(count < 0) break;

        }
    }

    public static void main(String[] args) {
        new Thread(new CountDown()).start();
    }
}
