package com.company;

import java.util.*;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if(node == null) return;

        for(var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if(fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String label) {
        var node = nodes.get(label);
        if(node == null)
            return;

        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        System.out.println(root.label);
        visited.add(root);
        for(var neighbour : adjacencyList.get(root)) {
            if(!visited.contains(neighbour))
                traverseDepthFirst(neighbour, visited);
        }
    }

    public void print() {
        for(var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }
}
