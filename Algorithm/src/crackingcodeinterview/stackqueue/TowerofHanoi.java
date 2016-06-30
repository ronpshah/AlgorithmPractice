package crackingcodeinterview.stackqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by shah_ on 6/18/2016.
 */
public class TowerofHanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Tower[] tower = new Tower[3];
        int n = in.nextInt();
        for (int i=0;i<3;i++){
            tower[i] = new Tower(i+1);
        }
        for (int i=n;i>=1;i--){
            tower[0].add(i);
        }
        tower[0].transfer(n,tower[2],tower[1]);
    }
}

class Tower{
    Stack<Integer> disks;
    int index;

    public Tower(int i){
        disks = new Stack<Integer>();
        index = i;
    }

    public void add(int a){
        disks.push(a);
    }

    public void moveTopTo(Tower t){
        int top = disks.pop();
        t.add(top);
        System.out.println("Move disk " +top +" from "+ index + "to " +t.index);
    }

    public void transfer(int n,Tower desc,Tower buffer){
        if (n<=0)
            return;

        transfer(n-1,buffer,desc);
        moveTopTo(desc);
        buffer.transfer(n-1,desc,this);
    }
}