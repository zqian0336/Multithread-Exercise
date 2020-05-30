package com.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //提交执行
        service.execute(new TheThread());
        service.execute(new TheThread());

        //关闭服务
        service.shutdown();


    }
}

class TheThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " running "+i);
        }
    }
}
