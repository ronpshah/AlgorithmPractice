package princeton.unionfind;

/**
 * Created by shah_ on 5/14/2016.
 */
public class DynamicConnectivity2 {

    int ids[];

    public DynamicConnectivity2(int n){
        ids = new int[n];
        for(int i=0;i<n;i++){
            ids[i] = i;
        }
    }
    public int root(int n){

        while(ids[n] != n){
            n = ids[n];
        }
        return n;
    }
    public boolean isConnected(int p,int q){
        return root(p) == root(q);
    }

    public void Union(int p,int q){
        int idp = root(p);
        int idq = root(q);

        if(!isConnected(p,q)){

            ids[idp] = idq;     //P root = q root
        }
    }
    public void display(){
        for(int i=0;i<ids.length;i++){
            System.out.println(ids[i]);
        }
    }
    public static void main(String[] args) {
        DynamicConnectivity2 DC = new DynamicConnectivity2(10);

        DC.Union(5,0);
        DC.Union(5,6);
        DC.Union(1,2);
        DC.Union(2,7);
        DC.Union(8,3);
        DC.Union(3,4);
        DC.Union(4,9);

        DC.display();
    }
}
