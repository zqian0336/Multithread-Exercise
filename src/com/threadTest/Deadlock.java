package com.threadTest;

public class Deadlock {
    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(0, "Mulan");
        Makeup makeup2 = new Makeup(1, "Snow White");
        new Thread(makeup1).start();
        new Thread(makeup2).start();

    }

}

class Lipstick{

}

class Mirror{

}

class Makeup implements Runnable{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    private int choice;
    private String name;

    public Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void makeup() throws InterruptedException {
        if(this.choice == 0){
            synchronized (lipstick){
                System.out.println(this.name + " get lipstick");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.name + " get mirror");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.name + " get mirror");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.name + " get lipstick");
            }
        }

    }
}
