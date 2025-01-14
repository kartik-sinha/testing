package Sorting;

// Worst case time complexity for Quick sort is O(n^2).
// If the list is either in ascending order or descending order, quick sort will take O(n^2) time.
//The best case for Quick Sort is when the list is split in the middle which is O(n logn)

public class QuickSort {
    //First element as pivot

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sort(int[] arr, int low, int high){
        if(low<high){
            int p=partition(arr, low, high);

            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr={74,45,12,2,78,98,89,51};
        new QuickSort().sort(arr, 0, arr.length-1);
        for(int i: arr)
            System.out.println(i);


    }
}
