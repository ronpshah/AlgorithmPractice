package princeton.sorting;

import java.util.Scanner;

/**
 * Created by shah_ on 5/27/2016.
 */
public class Insertion {

    public void solution(){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        sortInsertion(arr,n);
    }

    public void sortInsertion(int[] arr,int n){

        for (int i=0;i<n;i++){
            for (int j = i;j>0;j--){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }

        for (int i =0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Insertion I = new Insertion();
        I.solution();
    }
}
