package Sorting;

//Time Complexity : O(n^2)

//Selection Sort will always take O(n^2) whether the list is sorted or not.

//Selection sort is not stable i.e. order of same elements can be changed

public class SelectionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped=false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

}
