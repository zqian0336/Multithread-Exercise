package com.threadTest;

public class Race implements Runnable {

    private static String winner;
    @Override
    public void run(){
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("rabbit") && i%10 == 0){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean over = isOver(i);
            if(over) break;
            System.out.println(Thread.currentThread().getName() + " run "+i+" steps");
        }
    }

    public boolean isOver(int step){
        if(winner != null){
            return true;
        }
        if(step >= 100){
            winner = Thread.currentThread().getName();
            System.out.println(winner + " is winner ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "Rabbit").start();
        new Thread(race, "Turtle").start();
    }
}
