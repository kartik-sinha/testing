package Sorting;

//Time Complexity - O(n^2)

//Best Case of Insertion Sort is that list is sorted in ascending order ( It will take O(n) time )

//Worst Case of Insertion Sort is that list is sorted in descending order ( It will take O(n^2) time )

//Insertion sort is stable i.e. order of same elements will not be changed

public class InsertionSort {
    public void sort(int []arr){
        for(int i=1; i<arr.length; i++){
            int val=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>val){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=val;
        }
        for(int i: arr)
            System.out.println(i);
    }
    public static void main(String[] args) {
        new InsertionSort().sort(new int[]{24,45,12,2,78,98,89});
    }
}
