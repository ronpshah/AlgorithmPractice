package codefights;

import java.util.*;

/**
 * Created by shah_ on 6/19/2016.
 */
public class JetGrouping {

    String[][] catalogUpdate(String[][] catalog, String[][] updates) {

        Map<String,SortedSet<String>> map = new TreeMap<>();

        for (int i=0;i<catalog.length;i++){
            SortedSet<String> set = new TreeSet<String>();
            for (int j=0;j<catalog[i].length;j++){
                if (j==0){
                    map.put(catalog[i][j],set);
                }else {
                    String head = catalog[i][0];
                    TreeSet<String> temp = new TreeSet<String>(map.get(head));
                    temp.add(catalog[i][j]);
                    map.put(head,temp);
                }
            }
        }

        for (int i=0;i<updates.length;i++){
            TreeSet<String> set = new TreeSet<String>();
            for (int j=0;j<updates[i].length;j++){
                if (j==0){
                    if (map.containsKey(updates[i][j])){

                    }else{
                        map.put(updates[i][j],set);
                    }

                }else {
                    String head = updates[i][0];
                    TreeSet<String> temp = new TreeSet<String>(map.get(head));
                    temp.add(updates[i][j]);
                    map.put(head,temp);
                }
            }
        }

        String[][] ans = new String[map.size()][];
        int k=0,l=0;
        for (String key:map.keySet()){
            TreeSet<String> set = new TreeSet<String>(map.get(key));
            ans[k] = new String[set.size()+1];
            l=1;
            ans[k][0] = key;
            for (String d:set){
                ans[k][l] = d;
                l++;
            }
            k++;
        }
        return ans;
    }


    public static void main(String[] args) {
        String[][]  catalog = {{"Books", "Classics", "Fiction"},
                {"Electronics", "Cell Phones", "Computers", "Ultimate item"},
                {"Grocery", "Beverages", "Snacks"},
                {"Snacks", "Chocolate", "Sweets"},
                {"root", "Books", "Electronics", "Grocery"}};

        String[][] updates = {{"Snacks", "Marmalade"},
                {"Fiction", "Harry Potter"},
                {"root", "T-shirts"},
                {"T-shirts", "CodeFights"}};

        JetGrouping J = new JetGrouping();
        J.catalogUpdate(catalog,updates);

    }
}
