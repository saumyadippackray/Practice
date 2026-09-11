package org.example.Sorting;

public class BinarySort {
    public int sort(int[] arr,int start,int end,int value){
        int mid=(start+end)/2;
        while (start<end) {
            if (arr[mid] < value) {
                start = mid + 1;
            } else if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] == value) {
                return mid;

            }
            mid = (start + end) / 2;
            break;
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySort binarySort=new BinarySort();
        int[] arr= {-21,-10,-5,1,9,10,15};
        System.out.println(binarySort.sort(arr,0,arr.length-1,11));
    }
}
