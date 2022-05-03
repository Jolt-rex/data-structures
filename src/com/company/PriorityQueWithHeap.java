package com.company;

// insert O(log n)
// delete O(log n)
// due to bubble up / down
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
