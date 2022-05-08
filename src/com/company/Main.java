package com.company;

public class Main {

    public static void main(String[] args) {
        var graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addNode("X");

        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");

        var list = graph.topologicalSort();
        System.out.println(list);
    }
}
