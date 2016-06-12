package crackingcodeinterview.linkedlist;

/**
 * Created by shah_ on 5/30/2016.
 */
public class KthLastElement {

    Node head;

    public void addtoLast(int d){
        Node temp = new Node();
        temp.data = d;
        temp.next = null;

        if (head == null){
            head = temp;
        }else{
            Node traverse = head;
            while (traverse.next!=null){
                traverse = traverse.next;
            }
            traverse.next = temp;
        }
    }

    public void display(){

        if (head == null){
            System.out.println("Empty");
        }else{
            Node traverse = head;
            while (traverse!=null){
                System.out.println(traverse.data);
                traverse = traverse.next;
            }
        }
        System.out.println();
    }

    public int recursivekthLastelement(Node node,int k){

        if (node==null){
            return 0;
        }

        int i = recursivekthLastelement(node.next,k) + 1;
        if (i==k){
            System.out.println(node.data);
        }
        return i;
    }

    public Node getHead(){
        return head;
    }

    public void iterativekthLastelement1(Node node,int k){

        if (k<=0){
            return;
        }

       Node first = node;
       Node second = node;
       int i = 0;
        while (i<k){
            second = second.next;
            i++;
        }

        while (second!=null){
            first = first.next;
            second = second.next;
        }
        System.out.println(first.data);

    }

    public static void main(String[] args) {

        KthLastElement R = new KthLastElement();

        R.addtoLast(2);
        R.addtoLast(3);
        R.addtoLast(3);
        R.addtoLast(3);
        R.addtoLast(4);
        R.addtoLast(3);
        R.addtoLast(5);

        R.display();

        Node head = R.getHead();
        R.recursivekthLastelement(head,3);
        R.iterativekthLastelement1(head,3);
    }
}
