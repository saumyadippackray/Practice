package org.example.neetcode.binarySearch;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40},
                {41, 42, 43, 44},
                {45, 46, 47, 50}
        };

        int target = 50;
        System.out.println(SearchA2DMatrix.searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int ROW=matrix.length;
        int COLUMN=matrix[0].length;

        int top=0;
        int bot=ROW-1;

        while (top<=bot){
            int row=top+(bot-top)/2; //0

            if(matrix[row][0]>target)
                bot=row-1;
            else if (matrix[row][COLUMN-1]<target)
                top=row+1;
            else
                break;
        }
        if (!(top <= bot)) {
            return false;
        }
        int row=top+(bot-top)/2;

        int start=0;
        int end=COLUMN-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(matrix[row][mid]==target)
                return true;
            else if(matrix[row][mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return false;
    }

    //Input: matrix = [[1,2,4,8],
    //                 [10,11,12,13],
    //                 [14,20,30,40]], target = 10
    //                 [14,20,30,40]],
    //                 [14,20,30,40]]
}
