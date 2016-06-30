package leetcode;

/**
 * Created by shah_ on 6/16/2016.
 */
public class LongestSubstringPalindrome {

    //dynamic programming O(N^2)
    public String solution1(String s){

        int len = s.length();
        boolean palindrome[][] = new boolean[len][len];
        int startindex =0, endindex = 0;
        //single element is palindrome
        for (int i=0;i<len;i++){
            palindrome[i][i] = true;
            startindex = i;
            endindex = i;
        }

        //check two element is palindrome
        for (int i=0;i<len-1;i++){
            if (s.charAt(i) == s.charAt(i+1)){
                palindrome[i][i+1] = true;
                startindex = i;
                endindex = i+1;
            }
        }
        int ans = 1;
        //3..n
        for (int current =3;current<=len;current++){
            for (int i=0;i<=len-current;i++){
                int j = i + current - 1;

                if (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]){
                    palindrome[i][j] = true;
                    ans = Math.max(ans,current);
                    startindex = i;
                    endindex = j ;
                }
            }
        }
        return s.substring(startindex,endindex + 1);
    }


    public static void main(String[] args) {
        LongestSubstringPalindrome L = new LongestSubstringPalindrome();
        System.out.println(L.solution1("BANANAS"));
        System.out.println(L.solution1("BB"));
    }
}
