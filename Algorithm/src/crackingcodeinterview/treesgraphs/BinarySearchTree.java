package crackingcodeinterview.treesgraphs;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by shah_ on 6/26/2016.
 */
public class BinarySearchTree {


    public Tree addNodeTree(Tree root,int d){
        if (root == null){
            Tree node = new Tree();
            node.data = d;
            return node;
        }

        if (d<=root.data){
            root.left = addNodeTree(root.left,d);
        }else{
            root.right = addNodeTree(root.right,d);
        }

        return root;
    }
    public boolean search(Tree root,int d){

        if (root == null){
            return false;
        }
        boolean bool = false;
         if (root.data == d){
             bool = true;
             return bool;
         }
         else if(d<root.data){
            bool = search(root.left,d);
        }else if (d>root.data){
            bool = search(root.right,d);
        }
        return bool;
    }
    public void inorder(Tree root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public void preorder(Tree root){
        if (root == null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Tree root){
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    //use queue
    public void bfs(Tree root){
        if (root==null)
            return;

        Queue<Tree> openQueue = new LinkedList<Tree>();
        Queue<Tree> closeQueue = new LinkedList<Tree>();

        openQueue.add(root);

        while (!openQueue.isEmpty()){
            Tree processed = openQueue.remove();
            System.out.println(processed.data);
            if (!closeQueue.contains(processed)){
                if (processed.left!=null)
                    openQueue.add(processed.left);

                if (processed.right!=null)
                    openQueue.add(processed.right);

                closeQueue.add(processed);
            }
        }
    }

    //use stack
    public void dfs(Tree root){
        if (root == null){
            return;
        }

        Stack<Tree> openStack = new Stack<>();
        Stack<Tree> visitedStack = new Stack<>();
        openStack.add(root);

        while (!openStack.isEmpty()){
            Tree processed = openStack.pop();
            System.out.println(processed.data);
            if (!visitedStack.contains(processed)){

                if (processed.right!=null)
                    openStack.push(processed.right);
                if (processed.left!=null)
                    openStack.push(processed.left);

                visitedStack.push(processed);
            }
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
        System.out.println("Preorder");
        binarySearchTree.preorder(root);
        System.out.println("Postorder");
        binarySearchTree.postorder(root);

        System.out.println("Search "+binarySearchTree.search(root,3));
        System.out.println("Search "+binarySearchTree.search(root,13));

        System.out.println("Breadth First Search");
        binarySearchTree.bfs(root);
        System.out.println("Depth First Search");
        binarySearchTree.dfs(root);

    }
}
