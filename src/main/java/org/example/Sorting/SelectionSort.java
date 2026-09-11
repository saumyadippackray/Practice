package org.example.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("hi");
        int unsortedArray[]={-10,20,10,80,-5,90,2};
        int lastUnsortedPosition=unsortedArray.length;
        System.out.println(","+lastUnsortedPosition);
        int swap;
        while(lastUnsortedPosition>1){
            int largestIndex=0;

            for (int j=0;j<lastUnsortedPosition-1;j++){
                if(unsortedArray[j]>unsortedArray[largestIndex]){
                    largestIndex=j;
                }
            }
            System.out.println("lastUnsortedPosition"+lastUnsortedPosition+"largestIndex"+largestIndex);
            if(unsortedArray[largestIndex]>unsortedArray[lastUnsortedPosition-1]) {
                swap = unsortedArray[lastUnsortedPosition-1];
                unsortedArray[lastUnsortedPosition-1] = unsortedArray[largestIndex];
                unsortedArray[largestIndex] = swap;
            }
            lastUnsortedPosition--;
            for(int i=0;i<unsortedArray.length;i++){
                System.out.print(unsortedArray[i]+",");
            }
            System.out.println();
        }
    }
}
