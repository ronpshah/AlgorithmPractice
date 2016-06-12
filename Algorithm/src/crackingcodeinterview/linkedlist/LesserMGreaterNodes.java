package crackingcodeinterview.linkedlist;

/**
 * Created by shah_ on 5/31/2016.
 */
public class LesserMGreaterNodes {

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

    public Node solution1(int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        Node node = head;
        while (node != null){
            Node next = node.next;
            node.next = null;

            if (node.data<x){
                if (beforeStart==null){
                    beforeStart = node;
                    beforeEnd = node;
                }else{
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            }else{
                if (afterStart==null){
                    afterStart = node;
                    afterEnd = node;
                }else{
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart==null)
            return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //Two pointer

    public Node solution2(int x){
        Node beforeStart = null;
        Node afterStart = null;

        Node node = head;
        while (node!=null){
            Node next = node.next;
            node.next = null;

            if (node.data<x){
                if (beforeStart==null){
                    beforeStart = node;
                }else{
                    node.next = beforeStart;
                    beforeStart = node;
                }
            }else{
                if (afterStart==null){
                    afterStart = node;
                }else{
                    node.next=afterStart;
                    afterStart=node;
                }
            }
            node = next;
        }
        if (beforeStart==null)
            return afterStart;
        Node beforeEnd = beforeStart;
        while (beforeEnd.next!=null){
            beforeEnd = beforeEnd.next;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }
    public static void main(String[] args) {
        LesserMGreaterNodes R = new LesserMGreaterNodes();

        R.addtoLast(2);
        R.addtoLast(3);
        R.addtoLast(4);
        R.addtoLast(8);
        R.addtoLast(7);
        R.addtoLast(6);
        R.addtoLast(5);

        R.display();
        Node head=R.solution1(6);
        //Node head=R.solution2(6);
        R.display(head);
    }
}
