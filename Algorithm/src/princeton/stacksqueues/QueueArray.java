package princeton.stacksqueues;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by shah_ on 5/21/2016.
 */

//Circular Queue
public class QueueArray {

    int queuearr[];
    int size = 0;
    int front = -1, rear = -1;

    public QueueArray(){
        size = 5;
        queuearr = new int[size];

    }

    public void enqueue(int n){
        if (front == (rear + 1)% size ){
            System.out.println("Queue is full");
        }else{
            rear = (rear + 1) % (size);
            queuearr[rear] = n;
        }
    }


    public int dequeue(){
        if((front ) % size == rear){
            System.out.println("Queue is empty");
            return 0;
        }else{
            front = (front + 1)% size ;
            int temp = queuearr[front];
            queuearr[front] = 0;
            return temp;
        }
    }
    public static void main(String[] args) {

        QueueArray Q = new QueueArray();

        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);
        Q.enqueue(4);
        Q.enqueue(5);



        System.out.println(Q.dequeue());
        Q.enqueue(6);
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        Q.enqueue(6);
        System.out.println(Q.dequeue());
    }
}
