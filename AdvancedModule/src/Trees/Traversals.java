package Trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Traversals {
    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(TreeNode node){
        if (node == null){
            return ;
        }

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public static void postOrder(TreeNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    public static void levelOrder(TreeNode node){
        Queue<TreeNode> queue= new LinkedList<>();
        if(node == null) return ;

        queue.add(node);

        while(!queue.isEmpty()){
            node = queue.poll();
            if (node == null){
                continue;
            }

            System.out.println(node.val);
            queue.add(node.left);
            queue.add(node.right);


        }
    }


    public static void main(String[] args) {

        /**
         *                1
         *             /    \
         *            2      3
         *          / \    /  \
         *         4   5  null null
         *       / \  / \
         *      n  n n n(= null)
         */

        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);
        TreeNode leftLeaf = new TreeNode(4);
        TreeNode rightLeaf = new TreeNode(5);

        root.left = leftChild;
        root.right = rightChild;

        leftChild.left = null;
        leftChild.right = rightLeaf;

        leftLeaf.left = null;
        leftLeaf.right = null;

        rightLeaf.left = null;
        rightLeaf.right = null;

        rightChild.left = null;
        rightChild.right = null;

        //preOrder(root);

        //inOrder(root);

        //postOrder(root);

        levelOrder(root);
    }
}
