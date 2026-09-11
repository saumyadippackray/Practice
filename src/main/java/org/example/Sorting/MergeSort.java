package org.example.Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int unsortedArray[]={9,4,7,6,5,1,3,2};
        mergeSort(unsortedArray,0,unsortedArray.length-1);
        for(int i=0;i<unsortedArray.length;i++){
            System.out.println(unsortedArray[i]);
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort(int arr[], int start,int end){ //38,27,43,10

        if(end <=start)
            return;

        int mid=start+(end-start)/2; //1
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,mid,start,end);
    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[],int mid,int start,int end) { // start=0,mid=2,end=4 // end=5,mid=2 9,4,7 6,5
        //find the size of subarray to merge
        int size1=mid-start+1;
        int size2=end-mid;

        int[] arr1=new int[size1];
        int[] arr2=new int[size2];

        //copy the data to temp array
        for(int i=0;i<size1;i++)
        {
            arr1[i]=arr[start+i];
        }

        for(int i=0;i<size2;i++)
        {
            arr2[i]=arr[mid+i+1];
        }

        int i=0;
        int j=0;

        int k=start;

        while (i<size1 && j<size2){
            if(arr1[i]<=arr2[j]){
                arr[k]=arr1[i];
                i++;
            }
            else {
                arr[k]=arr2[j];
                j++;
            }
            k++;
        }

        while (i<size1){
            arr[k]=arr1[i];
            i++;
            k++;
        }
        while (j<size2){
            arr[k]=arr1[j];
            j++;
            k++;
        }
    }
}
