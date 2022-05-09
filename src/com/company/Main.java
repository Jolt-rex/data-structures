package com.company;

public class Main {

    public static void main(String[] args) {
        var graph = new WeightedGraph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 7);

        graph.print();
    }
}
