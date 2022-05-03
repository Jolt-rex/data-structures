package com.company;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = { 5, 3, 8, 4, 1, 2 };

        System.out.println(MaxHeap.kthLargestItem(numbers, 6));
    }
}
