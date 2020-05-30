package com.threadTest;

//Example of synchronized

public class BuyTicket {
    public static void main(String[] args) {
        Station station = new Station();
        new Thread(station, "Tom").start();
        new Thread(station, "Lee").start();
        new Thread(station, "Bob").start();

    }
}


class Station implements Runnable{

    //Ticket
    private int ticket = 10;
    //外部停止方式
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //同步方法，只有这里是主要活动区
    public synchronized void buy() throws InterruptedException {
        //判断有没有票
        if(ticket <= 0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+ " get Ticket "+ ticket--);
    }
}
