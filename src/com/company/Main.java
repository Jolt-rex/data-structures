package com.company;

public class Main {

    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);


        tree1.traverseLevelOrder();

        System.out.println("Done");
    }


}
