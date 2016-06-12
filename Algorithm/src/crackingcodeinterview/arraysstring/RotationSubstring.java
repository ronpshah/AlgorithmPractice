package crackingcodeinterview.arraysstring;

import com.sun.javafx.robot.impl.FXRobotHelper;

/**
 * Created by shah_ on 5/30/2016.
 */
public class RotationSubstring {

    public void solution(String s1, String s2){

        if (s1.length()==s2.length()){
            if (isSubstring(s1+s1,s2)){
                System.out.println("true");
            }
        }else{
            System.out.println("false");
        }
    }

    public boolean isSubstring(String s1s1, String s2){
        return s1s1.contains(s2);
    }
    public static void main(String[] args) {
        RotationSubstring R = new RotationSubstring();
        R.solution("waterbottle","erbottlewat");
        R.solution("waterbottle","bottlewat");
    }
}
