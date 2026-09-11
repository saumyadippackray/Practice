package org.example.Sorting;

public class QuickSort {
    public static int getPivotIndex(int arr[],int start,int end){
        int pivotValue=arr[end];
        int i=start-1;
        System.out.println("start"+start+"end="+end);
        for(int j=start;j<end;j++){
            if(arr[j]<pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }
        System.out.println("i="+i);
        i++;
        swap(arr,i,end);
        return i;
    }
    static void swap(int[] arr, int i, int j)
    {
        System.out.println(i+"--"+j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quickSort(int arr[],int start,int end){
       if(start<end){
         int pivotPoint=getPivotIndex(arr,start,end);
         quickSort(arr,start,pivotPoint-1);
         quickSort(arr,pivotPoint+1,end);
       }
    }
    public static void main(String[] args) {
        int unsortedArray[]={9,4,10,6,3,1,5,8};
        quickSort(unsortedArray,0,unsortedArray.length-1);
        for(int ji=0;ji<unsortedArray.length;ji++){
            System.out.print(unsortedArray[ji]+",");
        }
    }
}
