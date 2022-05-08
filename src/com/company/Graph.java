package com.company;

import java.sql.Array;
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

    public void traverseDepthFirstIterative(String label) {
        var node = nodes.get(label);
        if(node == null) return;

        HashSet<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            var current = stack.pop();

            if(visited.contains(current)) continue;

            System.out.println(current.label);
            visited.add(current);

            for(var neighbour : adjacencyList.get(current))
                if(!visited.contains(neighbour))
                    stack.push(neighbour);
        }
    }

    public void traverseBreadthFirst(String label) {
        var node = nodes.get(label);
        if(node == null) return;

        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            var current = queue.poll();

            if(visited.contains(current)) continue;

            System.out.println(current.label);
            visited.add(current);

            for(var neighbour : adjacencyList.get(current))
                if(!visited.contains(neighbour))
                    queue.add(neighbour);
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for(var node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while(!stack.empty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if(visited.contains(node)) return;

        visited.add(node);

        for(var neighbour : adjacencyList.get(node))
            topologicalSort(neighbour, visited, stack);

        stack.push(node);
    }

    public void print() {
        for(var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }
}
