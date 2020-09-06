package com.sber.lesson1.sort;

public class BinarySearch {

    public int binarySearch(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // /2
            int midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.

    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int array[] = {2, 3, 6, 10, 15, 20, 45, 60};
        int result = ob.binarySearch(array, 3);
        if (result < 0) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
