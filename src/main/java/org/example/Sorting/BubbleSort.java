package org.example.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int unsortedArray[]={-10,10,20,-30,100};
        int index=unsortedArray.length;
        int swap;
        while(index>0){
            for (int j=0;j<index-1;j++){
                if(unsortedArray[j]>unsortedArray[j+1]){
                    swap=unsortedArray[j];
                    unsortedArray[j]=unsortedArray[j+1];
                    unsortedArray[j+1]=swap;
                }
            }
            index--;
            for(int i=0;i<unsortedArray.length;i++){
                System.out.print(unsortedArray[i]+",");
            }
            System.out.println();
        }



    }
}
