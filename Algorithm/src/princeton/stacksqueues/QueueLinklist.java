package princeton.stacksqueues;

/**
 * Created by shah_ on 5/22/2016.
 */
public class QueueLinklist {

    Node front, rear;
    public void enqueue(int n){
        Node temp = new Node();
        temp.data = n;
        temp.next = null;
        if(front == null){
            front = rear = temp;
        }else{
            rear.next = temp;
            rear = temp;
        }
    }

    public int dequeue(){
        Node temp = front;
        if(front == null ){
            System.out.println("Queue empty");
            return 0;
        }else{
            front = temp.next;
        }
        return temp.data;
    }
    public static void main(String[] args) {
        QueueLinklist Q = new QueueLinklist();
        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);
        Q.enqueue(4);
        Q.enqueue(5);

        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
    }
}
