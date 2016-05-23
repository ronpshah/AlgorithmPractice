package princeton.stacksqueues;

/**
 * Created by shah_ on 5/21/2016.
 */
class Node{
    int data;
    Node next;
}
public class StackLinklist {

    Node top;

    public void push(int n){
        Node temp = new Node();
        temp.data = n;
        temp.next = top;
        top = temp;
    }

    public int pop(){
        Node temp = top;
        top = top.next;
        return temp.data;
    }

    public static void main(String[] args) {

        StackLinklist S = new StackLinklist();

        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);
        S.push(5);

        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
    }
}
