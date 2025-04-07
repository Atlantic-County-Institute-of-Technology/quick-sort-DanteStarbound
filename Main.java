//Joaquin Hughes
//4/3/2025
//Quick Sort

import java.util.Random;

public class Main {

    // The swithcing element for the program
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition method for Quick Sort
    private static int partition(int[] arr, int low, int high) {
// Choosing pivot as the last element
        int pivot = arr[high];
        int i = low - 1; // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Swap elements
            }
        }

        swap(arr, i + 1, high); // Place pivot in correct position
        return i + 1; // Return pivot index
    }

    //
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Partition the array
            quickSort(arr, low, pivotIndex - 1); // Sort left half
            quickSort(arr, pivotIndex + 1, high); // Sort right half
        }
    }

    //  generates a random array of given size
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    // Function to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Just a test to see if it works 1-10
    public static void main(String[] args) {
        int[] arr1 = generateRandomArray(10, 1, 100);
        System.out.println("Original Array (10 items):");
        printArray(arr1);
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println("Sorted Array:");
        printArray(arr1);

// another one but 50 items
        int[] arr2 = generateRandomArray(50, 1, 500);
        System.out.println("\nOriginal Array (50 items):");
        printArray(arr2);
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Sorted Array:");
        printArray(arr2);

    }
}
