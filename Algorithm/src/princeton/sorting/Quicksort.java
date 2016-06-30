package princeton.sorting;

import java.util.Scanner;

/**
 * Created by shah_ on 6/13/2016.
 */
public class Quicksort {

    public void solution(){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        quicksort(arr,0,n-1);
        display(arr);
    }

    public int partition(int arr[],int start,int end){
        int i = start;
        int j = end + 1;
        int pivot = start;
        while (true){
            while (arr[++i]<arr[pivot]){
                if (i==end)
                    break;
            }
            while (arr[--j]>arr[pivot]){
                if (j==start)
                    break;
            }

            if (i>=j)
                break;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;

        return j;
    }

    /* 5 4 3 8 2*/

    public void quicksort(int[] arr,int start,int end){
        if (start<end){
            int p = partition(arr,start,end);
            quicksort(arr,start,p-1);
            quicksort(arr,p+1,end);
        }
    }

    void display(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Quicksort Q = new Quicksort();
        Q.solution();
    }
}
