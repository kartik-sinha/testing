package Sorting;

class HeapSortUsingHeapify {
    // Function to heapify a subtree rooted at node i
    public void heapify(int[] arr, int n, int i) {
        int largest = i;    // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2;  // right child

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);  // Recursively heapify the affected subtree
        }
    }

    // Main function to sort an array using heap sort
    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // Utility function to swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSortUsingHeapify heapSort = new HeapSortUsingHeapify();
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort.heapSort(arr);

        System.out.println("Sorted array is:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
