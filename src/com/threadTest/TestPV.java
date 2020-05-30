package com.threadTest;

import java.util.LinkedList;
import java.util.Queue;

public class TestPV {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();

    }


}

class Producer extends Thread {

    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            try {
                container.push(new Chicken(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Produce "+i+" chicken");
        }

    }
}


class Consumer extends Thread {

    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("Eat "+container.pop().id + " Chicken");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer{

    //容器大小
    Queue<Chicken> chickens = new LinkedList<>();


    int max = 10;

    //生产者放入产品
    public synchronized void push(Chicken chicken) throws InterruptedException {

        //如果容器满了，就需要等待消费者消费
        if (chickens.size() == max){
            this.wait();
            //通知消费者，生产等待
        }

        //如果没有满，继续丢入
        chickens.offer(chicken);

        //有产品了，通知消费者消费
        //
        this.notifyAll();
    }

    public synchronized Chicken pop() throws InterruptedException {

        //如果容器空了，等待生产者生产
        if(chickens.size() == 0){
            this.wait();

        }

        Chicken c = chickens.poll();

        //吃完一只鸡，继续通知生产者
        this.notifyAll();
        return c;
    }

}
