package crackingcodeinterview.treesgraphs;

/**
 * Created by shah_ on 7/2/2016.
 */
public class BalancedBST {

    public int getHeight(Tree root){
        if (root==null){
            return 0;
        }
        int leftheight = getHeight(root.left)+1;
        int rightheight = getHeight(root.right)+1;

        if (leftheight>rightheight){
            return leftheight;
        }else{
            return rightheight;
        }
    }

    public boolean isBalanced(Tree root){
        if (root==null){
            return true;
        }

        int ans = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (ans>1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int checkHeights(Tree root){
        if (root == null){
            return 0;
        }

        int leftheight = checkHeights(root.left);
        if (leftheight == -1){
            return -1;
        }
        int rightheight = checkHeights(root.right);
        if (rightheight == -1){
            return -1;
        }
        int heighdiff = leftheight - rightheight;
        if (Math.abs(heighdiff)>1){
            return -1;
        }else{
            return Math.max(leftheight,rightheight) + 1;
        }
    }

    public boolean isBalance2(Tree root){
        int ans = checkHeights(root);
        if (ans==-1){
            return false;
        }else{
            System.out.println(ans);
            return true;
        }
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

        System.out.println("Inorder");
        binarySearchTree.inorder(root);

        BalancedBST B = new BalancedBST();

        System.out.println("Height of Tree: "+B.getHeight(root));
        System.out.println("Is Balanced "+B.isBalanced(root));
        System.out.println("Is Bal "+B.isBalance2(root));
    }
}
