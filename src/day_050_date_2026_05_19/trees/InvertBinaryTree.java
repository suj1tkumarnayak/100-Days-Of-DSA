package day_050_date_2026_05_19.trees;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
        this.right = right;
     }
 }

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        treeTraversal(root);

        //System.out.println(invertTree(root));
    }
    public static void treeTraversal(TreeNode root){
        if(root == null){
            return;
        }

//        System.out.println(root.left);
//        System.out.println(root.right);
        treeTraversal(root.left);
        System.out.println(root.val);

        treeTraversal(root.right);

    }
    public static TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left!=null){
                queue.offer(node.left);
            }

            if(node.right!=null){
                queue.offer(node.right);
            }
        }

        return root;
    }
}
