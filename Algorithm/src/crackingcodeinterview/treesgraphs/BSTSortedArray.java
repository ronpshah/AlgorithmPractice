package crackingcodeinterview.treesgraphs;

/**
 * Created by shah_ on 7/3/2016.
 */
public class BSTSortedArray {

    public Tree createMinimalBST(int[] arr){
        return createMinimalBST(arr,0,arr.length-1);
    }

    private Tree createMinimalBST(int[] arr, int start, int end) {

        /*if (start > end) {
            return null;
        }*/
        if (start<=end) {
            int mid = (start + end) / 2;
            Tree root = new Tree(arr[mid]);
            root.left = createMinimalBST(arr, start, mid - 1);
            root.right = createMinimalBST(arr, mid + 1, end);
            return root;
        }
        return null;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        BSTSortedArray B = new BSTSortedArray();
        Tree root = B.createMinimalBST(arr);

        BinarySearchTree BST = new BinarySearchTree();
        BST.inorder(root);


    }
}
