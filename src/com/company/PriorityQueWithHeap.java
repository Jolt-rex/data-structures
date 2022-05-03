package com.company;

public class PriorityQueWithHeap {
    private Heap heap = new Heap(50);

    public void add(int item) {
        heap.insert(item);
    }

    public int remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
