package strive.sheet.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroMatrixBootForce {
    //Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
    //Input: matrix=[[0,1,2,0]
    //              ,[3,4,5,2]
    //              ,[1,3,1,5]]

    //Output:[[0,0,0,0]
    //       ,[0,4,5,0]
    //       ,[0,3,1,0]]

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 2,0)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 4, 5,2)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 3, 1,5)));

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix){
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++)
            {
                if(matrix.get(i).get(j)==0){
                    markRow(matrix.get(i));
                    markColumn(matrix,j);
                }
            }
        }
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++)
            {
                if(matrix.get(i).get(j)==-1){
                    matrix.get(i).set(j,0);
                }
            }
        }
        return matrix;
    }

    public static void markRow(ArrayList<Integer> matrixRow){
        for(int i=0;i<matrixRow.size();i++){
            if(matrixRow.get(i)!=0) {
                matrixRow.set(i, -1);
            }
        }
    }

    public static void markColumn(ArrayList<ArrayList<Integer>> matrix,int column){
        for(int i=0;i<matrix.size();i++){
            if(matrix.get(i).get(column)!=0){
                matrix.get(i).set(column,-1);
            }
        }
    }
}
