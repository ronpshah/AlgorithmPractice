package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shah_ on 6/25/2016.
 */
public class Sum3Zero {

    public List<List<Integer>> solution1(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i==0||nums[i-1]!=nums[i])
            for (int j=i+1;j<nums.length-1;j++){

                for (int k=j+1;k<nums.length;k++){

                    if (nums[i] + nums[j] + nums[k] ==0){
                        //System.out.println(nums[i] + " "+nums[j]+" "+nums[k]);
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;

                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Sum3Zero S = new Sum3Zero();
        S.solution1(nums);
        S.threeSum(nums);
    }
}
