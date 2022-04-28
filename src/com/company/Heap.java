package com.company;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int size) {
        heap = new int[size];
        this.size = 0;
    }

    public void insert(int value) {
        if(isFull())
            throw new IllegalStateException();

        heap[size++] = value;

        bubbleUp();
    }

    public boolean isFull() {
        return size == heap.length;
    }

    private void bubbleUp() {
        var index = size - 1;
        while(index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    public void print() {
        for(int i = 0; i < this.size; i++) {
            System.out.println(heap[i]);
        }
    }
}
