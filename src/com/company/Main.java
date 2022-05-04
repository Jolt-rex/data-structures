package com.company;

public class Main {

    public static void main(String[] args) {
        var graph = new Graph();

        graph.addNode("Billy");
        graph.addNode("Jolt");
        graph.addNode("Hannah");

        graph.print();

        graph.addEdge("Jolt", "Hannah");
        graph.addEdge("Jolt", "Billy");

        graph.print();

        graph.removeEdge("Jolt", "Hannah");
        graph.print();
    }
}
