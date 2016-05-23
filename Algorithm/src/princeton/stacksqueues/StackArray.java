package princeton.stacksqueues;

/**
 * Created by shah_ on 5/21/2016.
 */
public class StackArray {

    int stackarr[];
    int lenght = 0;
    int top = 0;
    public StackArray(){
        lenght = 1;
        stackarr = new int[lenght];
    }

    public void push(int n){
        if(top == lenght){
            //doubling array dynamically
            int[] tempstack = new int[lenght * 2];
            for (int i=0;i<lenght;i++){
                tempstack[i] = stackarr[i];
            }
            stackarr = tempstack;
            lenght = lenght * 2;
        }
        stackarr[top] = n;
        top++;
    }
    public int pop(){
        if(top==0){
            System.out.println("Stack Empty");
            return 0;
        }else{
            top--;
            int temp = stackarr[top];
            return temp;
        }
    }
    public static void main(String[] args) {
        StackArray S = new StackArray();

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
