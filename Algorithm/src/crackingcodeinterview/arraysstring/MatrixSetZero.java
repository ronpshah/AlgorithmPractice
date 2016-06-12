package crackingcodeinterview.arraysstring;

import other.MaxSubArray2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by shah_ on 5/30/2016.
 */
public class MatrixSetZero {

    public void solution(){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                matrix[i][j] = in.nextInt();
            }
        }

        Set rowset = new HashSet<Integer>();
        Set colset = new HashSet<Integer>();

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (rowset.contains(i)||colset.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }


        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MatrixSetZero M = new MatrixSetZero();
        M.solution();
    }
}
