package other;

import java.util.Scanner;

/**
 * Created by shah_ on 5/25/2016.
 */

//Divide and Conquer
public class MaxSubArray2 {

    public void solution(){

        Scanner in = new Scanner(System.in);

        long t = in.nextLong();

        for (long i=0;i<t;i++) {

            int n = in.nextInt();
            int m = in.nextInt();
            long arr[] = new long[n];

            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            long ans = maxSubArray(arr,n,m);
            System.out.println(ans);
        }


    }

    public long maxSubArray(long arr[], int n,int mod){

        if (n==1){
            return arr[0];
        }

        int m = n/2;
        long leftarr[] = new long[m];
        long rightarr[] = new long[n-m];
        for (int i=0;i<m;i++){
            leftarr[i] = arr[i];
        }
        for (int i=m;i<n;i++){
            rightarr[i-m] = arr[i];
        }
        long left_mss = maxSubArray(leftarr,m, mod);
        long right_mss = maxSubArray(rightarr,n-m, mod);

        long leftsum = Long.MIN_VALUE;
        long rightsum = Long.MIN_VALUE;
        long sum = 0;
        for (int i = m;i<n;i++){
            sum += arr[i];
            rightsum = max(rightsum, sum);
        }
        sum =0;
        for (int i = (m-1); i>=0 ; i--){
            sum += arr[i];
            leftsum = max(leftsum, sum);
        }
        leftsum = leftsum % mod;
        rightsum = rightsum % mod;
        long ans = max(leftsum,rightsum);
        return max(ans, (leftsum+rightsum)%mod);

    }

    public long max(long a,long b){
        if (a>b)
            return a;
        else
            return b;
    }
    public static void main(String[] args) {
        new MaxSubArray2().solution();
    }
}
