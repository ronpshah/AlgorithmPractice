package crackingcodeinterview.arraysstring;

import java.util.Arrays;

/**
 * Created by shah_ on 5/28/2016.
 */
public class PermutationTwoString {

    public boolean isTwoPermutation1(String str1,String str2){

        if (str1.length()!=str2.length()){
            return false;
        }

        char[] charr1 = str1.toCharArray();
        char[] charr2 = str2.toCharArray();

        Arrays.sort(charr1);
        Arrays.sort(charr2);

        if (Arrays.equals(charr1,charr2)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isTwoPermutation2(String str1, String str2){

        if (str1.length()!=str2.length()){
            return false;
        }

        int charcount[] = new int[256];
        for (int i=0;i<str1.length();i++){
            int val = str1.charAt(i);
            charcount[val] = charcount[val] + 1;
        }

        for (int i=0;i<str2.length();i++){
            int val = str2.charAt(i);
            if (charcount[val]<=0){
                return false;
            }
            charcount[val] = charcount[val] - 1;
        }
        return true;
    }
    public static void main(String[] args) {
        PermutationTwoString P = new PermutationTwoString();

        System.out.println(P.isTwoPermutation1("ronak","ronak"));
        System.out.println(P.isTwoPermutation1("dsafd","daffaad"));

        System.out.println(P.isTwoPermutation2("ronak","ronak"));
        System.out.println(P.isTwoPermutation2("Rona","Roona"));
        System.out.println(P.isTwoPermutation2("dsafd","daffaad"));
    }
}
