package com.company;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int size) {
        heap = new int[size];
        this.size = 0;
    }

    public void insert(int value) {
        // check if we need to resize first
        if (heap.length <= size)
            resizeHeap();

        heap[size++] = value;
    }

    private void resizeHeap() {
        int[] newHeap = new int[size * 2];
        for(int i = 0; i < size * 2; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public void print() {
        for(int i = 0; i < this.size; i++) {
            System.out.println(heap[i]);
        }
    }
}
