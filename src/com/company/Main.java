package com.company;

public class Main {

    public static void main(String[] args) {
        Heap hp = new Heap(10);

        hp.insert(10);
        hp.insert(12);
        hp.insert(13);
        hp.insert(14);
        hp.insert(22);

        hp.remove();

        hp.print();
    }
}
