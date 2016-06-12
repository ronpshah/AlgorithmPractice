package other;

import java.util.Scanner;

/**
 * Created by shah_ on 5/25/2016.
 */
public class MaxSubArray1 {

    public void solution(){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i=0;i<t;i++){

            int n = in.nextInt();
            int m = in.nextInt();
            int arr[] = new int[n];

            for (int j = 0;j<n;j++){
                arr[j] = in.nextInt();
            }
            int ans = 0;
            for (int j = 0; j<n; j++){
                int sum = 0;
                for (int k = 1;k<=n;k++){
                    if (j+k>n)
                        break;
                    sum = sum + arr[j+k - 1];
                    ans = max(ans%m,sum%m);
                }
            }
            System.out.println(ans);
        }

    }

    public int max(int a,int b){
        if (a>b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) {
        new MaxSubArray1().solution();
    }
}
