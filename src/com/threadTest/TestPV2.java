package com.threadTest;

public class TestPV2 {
    public static void main(String[] args) {

        //不论怎么样，都指向同一个对象
        Intersection intersection = new Intersection();
        new NS(intersection).start();
        new EW(intersection).start();
    }
}


class NS extends Thread {

    Intersection intersection;
    public NS(Intersection intersection){
        this.intersection = intersection;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.intersection.nspass(new Vehicle("NSCar"));
        }
    }
}

class EW extends Thread {
    Intersection intersection;
    public EW(Intersection intersection){
        this.intersection = intersection;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.intersection.ewpass(new Vehicle("EWCar"));
        }
    }
}

class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }
}

class Intersection {
    private Vehicle vehicle;
    private boolean flag = true;
    public synchronized void nspass(Vehicle vehicle) {
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        this.notifyAll();
        this.vehicle = vehicle;
        this.flag = !this.flag;
        System.out.println("NS Pass Vehicle "+ this.vehicle.name);

    }

    public synchronized void ewpass(Vehicle vehicle) {
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notifyAll();
        this.vehicle = vehicle;
        this.flag = !this.flag;
        System.out.println("EW Pass Vehicle "+this.vehicle.name);

    }
}
