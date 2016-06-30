package crackingcodeinterview.stackqueue;

import java.util.Stack;

/**
 * Created by shah_ on 6/12/2016.
 */
public class StackTwoMinTrack {

    Stack top = new Stack();
    Stack min = new Stack();
    int lastmin = Integer.MAX_VALUE;

    public void push(int d){
        if (lastmin>=d){
            min.push(d);
            lastmin = d;
        }
        top.push(d);
    }

    public int pop(){
        int current =(int) top.pop();
        int currentmin = (int) min.peek();
        if (current == currentmin){
            min.pop();
        }
        return current;
    }

    public int getMinimum(){
        return (int)min.peek();
    }

    public static void main(String[] args) {
        StackTwoMinTrack S = new StackTwoMinTrack();


        S.push(6);
        S.push(5);
        S.push(3);
        S.push(7);

        System.out.println(S.getMinimum());
        S.pop();
        System.out.println(S.getMinimum());
        S.pop();
        System.out.println(S.getMinimum());
        S.pop();
        System.out.println(S.getMinimum());
        S.pop();
    }
}
