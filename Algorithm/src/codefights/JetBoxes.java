package codefights;

import java.util.Arrays;

/**
 * Created by shah_ on 6/19/2016.
 */
public class JetBoxes {

    int packageBoxing(int[] package1, int[][] boxes) {

        Arrays.sort(package1);
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<boxes.length;i++){
            int[] arr = boxes[i];
            Arrays.sort(arr);

            if (package1[0]<=arr[0] && package1[1]<=arr[1] && package1[2]<=arr[2]){
                int temp = arr[0] * arr[1] * arr[2];
                if (temp<min){
                    min = temp;
                    ans = i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        JetBoxes J = new JetBoxes();
        int[] pack = {4,4,2};
        int[][] box = {{2,4,4},
                {4,4,3}};
        System.out.println(J.packageBoxing(pack,box));
    }
}
