package crackingcodeinterview.arraysstring;

/**
 * Created by shah_ on 5/28/2016.
 */
public class CompressionString {

    public String solution1(String str){

        StringBuffer sb = new StringBuffer();
        int count = 1;
        char ch = str.charAt(0);
        for (int i=0;i<str.length()-1;i++){

            if (str.charAt(i) == ch){
               count++;
            }else {
                sb.append(ch);
                sb.append(count);
                ch = str.charAt(i);
                count=1;
            }
        }
        sb.append(ch);
        sb.append(count);
        String compressstr = sb.toString();
        if (str.length()>compressstr.length()){
            return compressstr;
        }else{
            return str;
        }
    }
    public static void main(String[] args) {
        CompressionString CS = new CompressionString();

        System.out.println(CS.solution1("aabcccccaaa"));
        System.out.println(CS.solution1("compressed"));
    }
}
