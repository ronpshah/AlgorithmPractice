package crackingcodeinterview.linkedlist;

/**
 * Created by shah_ on 5/31/2016.
 */
public class DeleteMiddleElement {

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

    public Node getKthNode(int k){
        Node traverse = head;

        if (head==null){
            return null;
        }
        else{
            int i =1;
            while (traverse!=null && i<k){
                i++;
                traverse = traverse.next;
            }
        }
        return traverse;
    }
    public void deleteElement(Node node){
        if (node==null){
            return;
        }

        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;

    }
    public static void main(String[] args) {

        DeleteMiddleElement R = new DeleteMiddleElement();
        R.addtoLast(2);
        R.addtoLast(3);
        R.addtoLast(3);
        R.addtoLast(3);
        R.addtoLast(4);
        R.addtoLast(3);
        R.addtoLast(5);

        R.display();
        Node node = R.getKthNode(5);
        R.deleteElement(node);
        R.display();
    }
}
