package com.sber.lesson1.sort;

public class BubbleSort {
    public void bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        int array[] = {12, 65, 48, 15, 1, 69, 35};

        ob.printArray(array);
        System.out.println();

        ob.bubbleSort(array);
        ob.printArray(array);
    }
}
