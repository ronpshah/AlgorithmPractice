package crackingcodeinterview.linkedlist;

/**
 * Created by shah_ on 6/11/2016.
 */


public class AddNumbers {

    Node sum;
    public Node addtoLast(Node head,int d){
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
        return head;
    }

    public Node addNumber(Node first, Node second,int carry){
        if (first==null && second==null && carry==0){
            return null;
        }

        Node result = new Node();
        int value = carry;
        if (first!=null){
            value += first.data;
        }
        if (second!=null){
            value += second.data;
        }

        result.data = value % 10;

        if (first!=null || second!=null){
            Node more = addNumber(first == null ? null:first.next,
                                    second == null ? null:second.next,value >= 10 ? 1:0);
            result.next = more;
        }
        return result;
    }

    public void display(Node headloc){

        if (headloc == null){
            System.out.println("Empty");
        }else{
            Node traverse = headloc;
            while (traverse!=null){
                System.out.println(traverse.data);
                traverse = traverse.next;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        AddNumbers A = new AddNumbers();
        Node first = null;
        first = A.addtoLast(first,2);
        first = A.addtoLast(first,4);
        first = A.addtoLast(first,3);

        Node second = null;
        second = A.addtoLast(second,5);
        second = A.addtoLast(second,6);
        second = A.addtoLast(second,4);

        Node sum = A.addNumber(first,second,0);
        A.display(sum);
    }
}
