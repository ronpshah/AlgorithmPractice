package crackingcodeinterview.stackqueue;

import princeton.sorting.Quicksort;

import java.util.Stack;

/**
 * Created by shah_ on 6/18/2016.
 */
public class QueueUsingStack {

    Stack<Integer> stackOld;
    Stack<Integer> stackNew;

    public QueueUsingStack(){
        stackOld = new Stack<Integer>();
        stackNew = new Stack<Integer>();
    }
    public void enqueue(int a){
        stackNew.push(a);
    }

    public void stackshift(){
        if (stackOld.isEmpty()){
            while (!stackNew.isEmpty()){
                int top = stackNew.pop();
                stackOld.push(top);
            }
        }
    }

    public int dequeue(){
        stackshift();
        return stackOld.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack Q = new QueueUsingStack();

        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);
        Q.enqueue(4);

        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());

    }
}
