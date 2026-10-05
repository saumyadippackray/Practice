package org.example.Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int unsortedArray[]={9,4,7,6,5};
        mergeSort(unsortedArray,0,unsortedArray.length-1,"original");
        for(int i=0;i<unsortedArray.length;i++){
            System.out.println(unsortedArray[i]);
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort(int arr[], int start,int end,String val){ //38,27,43,10
        System.out.println(val);
        if(start>=end)
            return;
        // Find the middle point
        int mid=start+(end-start)/2;
        // Sort first and second halves
        //System.out.println("start"+start+"mid"+mid+"end"+end);
        mergeSort(arr,start,mid,"first");// start=0,mid=2
        mergeSort(arr,mid+1,end,"second");// start=3,mid=5
        // Merge the sorted halves
        merge(arr,mid,start,end,val);

    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[],int mid,int start,int end,String val) { // start=0,mid=2 // end=5,mid=2
        // Find sizes of two subarrays to be merged
        System.out.println("merge");
        int n1=mid-start+1;//3
        int n2=end-mid;//3

        // Create temp arrays
        int tempLeft[]=new int[n2]; //9,4,7
        int tempRight[]=new int[n1]; //6,5,8

        // Copy data to temp arrays
        for(int i=0;i<n1;i++)
            tempRight[i]=arr[start+i];
        for(int i=0;i<n2;i++)
            tempLeft[i]=arr[mid+i+1];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int firstPointer=0;int secondPointer=0;
        // Initial index of merged subarray array
        int k=start;

        while (firstPointer<n1 && secondPointer<n2){
            if(tempRight[firstPointer]>tempLeft[secondPointer]){
                arr[k]=tempRight[firstPointer];
                firstPointer++;
            }
            else {
                arr[k]=tempLeft[secondPointer];
                secondPointer++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while (firstPointer<n1){
            arr[k]=tempRight[firstPointer];
            firstPointer++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (secondPointer<n2){
            arr[k]=tempLeft[secondPointer];
            secondPointer++;
            k++;
        }

    }
}
