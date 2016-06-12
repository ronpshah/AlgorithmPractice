package crackingcodeinterview.arraysstring;

import java.util.Scanner;

/**
 * Created by shah_ on 5/29/2016.
 */
public class ImageRotation {


    public void rotate90solution1 (){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] matrix  = new int[n][n];
        int[][] newmatix = new int[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j] = in.nextInt();
            }
        }
        int ii=0;
        for (int j=0;j<n;j++){
            int jj=0;
            for (int i=n-1;i>=0;i--){

                //System.out.print(matrix[i][j]);
               /* int temp = matrix[ii][jj];
                matrix[ii][jj] = matrix[i][j];
                matrix[i][j] = temp;*/
                newmatix[ii][jj] = matrix[i][j];
                jj++;
            }
            ii++;
            System.out.println();
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(newmatix[i][j]);
            }
            System.out.println();
        }

    }

    public void rotate90solution2(){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] matrix  = new int[n][n];
        int[][] newmatix = new int[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j] = in.nextInt();
            }
        }

        for (int layer = 0;layer<n/2;layer++){
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first;i<last;i++){
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        ImageRotation IR = new ImageRotation();
        //IR.rotate90solution1();
        IR.rotate90solution2();
    }
}
