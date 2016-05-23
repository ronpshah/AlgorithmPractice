package princeton.unionfind;

/**
 * Created by shah_ on 5/14/2016.
 */
public class DynamicConnectivity {

    int ids[];

    public DynamicConnectivity(int n){
        ids = new int[n];
        for(int i=0;i<n;i++){
            ids[i] = i;
        }
    }
    public boolean isConnected(int p,int q){
        if(ids[p] == ids[q]){
            return true;
        }else{
            return false;
        }
    }

    public void Union(int p,int q){
        int idsp = ids[p];
        int idsq = ids[q];

        if(!isConnected(p,q)) {
            ids[q] = idsp;
            for (int i = 0; i < ids.length; i++) {
                if (idsq == ids[i]) {
                    ids[i] = idsq;
                }
            }
        }
    }

    public void UnionK(int p,int q){
        int idsp = ids[p];
        int idsq = ids[q];

        if(!isConnected(p,q)) {
            for (int i = 0; i < ids.length; i++) {
                if (idsp == ids[i]) {
                    ids[i] = idsq;
                }
            }
        }
    }

    public void display(){
        for(int i=0;i<ids.length;i++){
            System.out.println(ids[i]);
        }
    }
    public static void main(String[] args) {

        DynamicConnectivity DC = new DynamicConnectivity(10);
        DC.Union(0,5);
        DC.Union(5,6);
        DC.Union(1,2);
        DC.Union(2,7);
        DC.Union(8,3);
        DC.Union(3,4);
        DC.Union(4,9);

        DC.display();
    }
}
