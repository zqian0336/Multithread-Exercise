package com.threadTest;

//状态检测　
public class StateWatch {
    public static void main(String[] args) throws InterruptedException {

        //每隔1秒打印一次///
        Thread t = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("////////////");
            }
        });

        Thread.State state = t.getState();
        System.out.println(state);

        t.start();
        state = t.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            //每隔0.1 sec 检测一次state
            state = t.getState();
            System.out.println(state);
        }

    }
}
