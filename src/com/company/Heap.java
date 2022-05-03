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

    // remove first index value
    public int remove() {
        if(isEmpty())
            throw new IllegalStateException();

        var root = heap[0];
        heap[0] = heap[--size];

        bubbleDown();

        return root;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) return index;

        if (!hasRightChild(index)) return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) return true;

        var isValid = heap[index] >= leftChild(index);

        if (hasRightChild(index))
            isValid &= heap[index] >= rightChild(index);

        return isValid;
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public boolean isEmpty() {
        return size == 0;
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

    private void bubbleDown() {
        var index = 0;
        while(index <= size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
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
