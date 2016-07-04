package leetcode;

/**
 * Created by shah_ on 7/1/2016.
 */

class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) { val = x; }

}
public class SwapNodesPair {

    public ListNode addtoLast(ListNode head,int d){
        ListNode temp = new ListNode();
        temp.val = d;
        temp.next = null;

        if (head == null){
            head = temp;
        }else{
            ListNode traverse = head;
            while (traverse.next!=null){
                traverse = traverse.next;
            }
            traverse.next = temp;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
       if (head==null || head.next==null){
           return head;
       }

        ListNode p = head;
        ListNode q = p.next;
        if (q.next==null){
            head = q;
            p.next = null;
            q.next = p;
            return head;
        }
        head = q;

        while (p!=null && p.next!=null ){
            ListNode t = q.next;
            q.next = p;
            if (t!=null&&t.next!=null){
                p.next = t.next;
            }else {
                p.next = t;
            }
            //p.next = t;
            p = t;
            if (p!=null && p.next!=null)
                q = p.next;
        }
        return head;
    }

    public void display(ListNode headloc){

        if (headloc == null){
            System.out.println("Empty");
        }else{
            ListNode traverse = headloc;
            while (traverse!=null){
                System.out.println(traverse.val);
                traverse = traverse.next;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SwapNodesPair A = new SwapNodesPair();
        ListNode first = null;
        first = A.addtoLast(first,2);
        first = A.addtoLast(first,3);
        first = A.addtoLast(first,4);
        first = A.addtoLast(first,5);

        A.display(first);
        first = A.swapPairs(first);
        A.display(first);
    }
}
