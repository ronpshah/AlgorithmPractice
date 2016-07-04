package crackingcodeinterview.treesgraphs;

/**
 * Created by shah_ on 7/4/2016.
 */
public class CheckBST {

    public boolean isBST1(Tree root,int size){
        int[] arr = new int[size];

        isBST1(root,arr);

        for (int i =0;i<arr.length-1;i++){
            if (!(arr[i]<arr[i+1])){
                return false;
            }
        }
        return true;
    }

    int index = 0;
    public void isBST1(Tree root, int[] arr){
        if (root==null){
            return;
        }

        isBST1(root.left,arr);
        arr[index++] = root.data;
        isBST1(root.right,arr);
    }
    static int last_max = Integer.MIN_VALUE;

    public static boolean isBST2(Tree root){
        if (root==null){
            return true;
        }

        if (!isBST2(root.left))
            return false;

        if (root.data<=last_max)
            return false;

        last_max = root.data;

        if (!isBST2(root.right))
            return false;

        return true;
    }

    public boolean isBST3(Tree root, int min,int max){

        if (root == null){
            return true;
        }

        if (root.data<=min && root.data>max){
            return false;
        }

        if (isBST3(root.left,min,root.data) && isBST3(root.right,root.data,max)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Tree root = null;
        root = binarySearchTree.addNodeTree(root,5);
        root = binarySearchTree.addNodeTree(root,7);
        root = binarySearchTree.addNodeTree(root,3);
        root = binarySearchTree.addNodeTree(root,6);
        root = binarySearchTree.addNodeTree(root,8);
        root = binarySearchTree.addNodeTree(root,2);
        root = binarySearchTree.addNodeTree(root,4);

        CheckBST C = new CheckBST();
        System.out.println("Is BST 1 "+C.isBST1(root,7));
        System.out.println("Is BST 2 "+CheckBST.isBST2(root));
        System.out.println("Is BST 3 "+C.isBST3(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
