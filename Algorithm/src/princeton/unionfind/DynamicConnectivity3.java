package princeton.unionfind;

/**
 * Created by shah_ on 5/15/2016.
 */

//weighted average
public class DynamicConnectivity3 {

    int ids[];
    int sz[];
    public DynamicConnectivity3(int n){
        ids = new int[n];
        sz = new int[n];
        for(int i=0;i<n;i++){
            ids[i] = i;
        }
        for(int i=0;i<n;i++){
            sz[i] = 1;
        }
    }
    public int root(int n){

        while(ids[n] != n){
            ids[n] = ids[ids[n]]; //Making every node of tree to point its grandparent thus halving tree.
            n = ids[n];
        }
        return n;
    }

    public boolean isConnected(int p,int q){
        return root(p) == root(q);
    }

    public void Union(int p,int q){
        int i = root(p);
        int j = root(q);

        if(!isConnected(p,q)){
            if(sz[i]<sz[j]){
               ids[i] = j;
               sz[j] = sz[i] + sz[j];
            }else{
                ids[j] = i;
                sz[i] = sz[i] + sz[j];
            }
        }
    }

    public void display(){
        for(int i=0;i<ids.length;i++){
            System.out.println(ids[i]);
        }
        System.out.println();
        for(int i=0;i<ids.length;i++){
            System.out.println(sz[i]);
        }
    }
    public static void main(String[] args) {
        DynamicConnectivity3 DC = new DynamicConnectivity3(10);
        DC.Union(5,6);
        DC.Union(5,0);

        DC.Union(1,2);
        DC.Union(2,7);
        DC.Union(8,3);
        DC.Union(3,4);
        DC.Union(4,9);

        DC.display();
    }
}
