package crackingcodeinterview.arraysstring;

/**
 * Created by shah_ on 5/28/2016.
 */
public class ReverseString {

    public String reverse(String str){

        if (str == null || str.length()<=1){
            return str;
        }
        else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

    public static void main(String[] args) {

        ReverseString R = new ReverseString();
        System.out.println(R.reverse("Ronak"));
    }
}
