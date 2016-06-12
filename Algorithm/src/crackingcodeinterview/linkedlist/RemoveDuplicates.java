package crackingcodeinterview.linkedlist;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by shah_ on 5/30/2016.
 */
public class RemoveDuplicates {
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
    public Node getHead(){
        return head;
    }
    public void recursiveDisplay(Node node){
        if (node==null){
            return;
        }

        recursiveDisplay(node.next);
        System.out.println(node.data);
    }

    public void removeDuplicates1(){
        Hashtable table  = new Hashtable();
        Node traverse = head;
        Node previous = null;
        while (traverse!=null){
            if (table.containsKey(traverse.data)){
                previous.next = traverse.next;
                //previous = previous.next; //Wrong assumption move pointer only when new item detected (case of 3 same number simultaneously)
            }else{
                table.put(traverse.data,true);
                previous = traverse;
            }
            traverse = traverse.next;
        }
    }

    public void removeDuplicates2(){
        Node current = head;
        Node traverse = null;
        Node previous = null;
        while (current.next!=null){
            traverse = current.next;
            previous = current;
            while (traverse!=null){
                if (traverse.data == current.data){
                    previous.next = traverse.next;
                }else{
                    previous = traverse;
                }
                traverse = traverse.next;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates R = new RemoveDuplicates();

        R.addtoLast(2);
        R.addtoLast(3);
        R.addtoLast(3);
        R.addtoLast(3);
        R.addtoLast(4);
        R.addtoLast(3);
        R.addtoLast(5);

        R.display();
        Node head = R.getHead();
        R.recursiveDisplay(head);
        //R.removeDuplicates1();
        R.removeDuplicates2();
        System.out.println("Removing Duplicates");
        R.display();

    }
}
