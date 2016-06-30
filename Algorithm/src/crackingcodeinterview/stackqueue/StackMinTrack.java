package crackingcodeinterview.stackqueue;

import princeton.stacksqueues.*;

/**
 * Created by shah_ on 6/12/2016.
 */

class LinklistNode{
    int data;
    int min;
    LinklistNode next;

}
public class StackMinTrack {

    LinklistNode top;
    int min = Integer.MAX_VALUE;

    public void push(int d){
        LinklistNode current = new LinklistNode();
        current.data = d;
        if (min>d){
            min = d;
        }
        current.min = min;
        current.next = top;
        top = current;
    }

    public int pop(){
        if (top == null){
            return 0;
        }
        LinklistNode current = top;
        top = top.next;
        return current.data;
    }

    public int getMinimum(){
        if (top == null){
            return Integer.MAX_VALUE;
        }
        return top.min;
    }


    public static void main(String[] args) {
        StackMinTrack S = new StackMinTrack();

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
