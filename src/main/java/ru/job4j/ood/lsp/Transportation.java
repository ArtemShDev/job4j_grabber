package ru.job4j.ood.lsp;

interface Vechicle {
    void run();
}

class MiniTrack implements Vechicle {
    @Override
    public void run() {
        System.out.println("Transportation by mini truck!");
    }
}

class Track implements Vechicle {
    @Override
    public void run() {
        System.out.println("Transportation by big truck!");
    }
}

class Bike implements Vechicle {
    @Override
    public void run() {
        System.out.println("Transportation by bike!");
    }
}

public class Transportation {
    private Vechicle transport;

    public Transportation(Vechicle transport) {
        this.transport = transport;
    }

    public static void main(String[] args) {
        Transportation tr = new Transportation(new Track());
        if (tr.transport.getClass() == MiniTrack.class) {
            System.out.println("80 rubles per item");
        } else if (tr.transport.getClass() == Track.class) {
            System.out.println("100 rubles per item");
        } else if (tr.transport.getClass() == Bike.class) {
            System.out.println("80 rubles per item");
        }
    }
}