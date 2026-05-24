package day_055_date_2026_05_24.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    // Definition for a binary tree node.
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Mock Tree:
        //      1
        //     / \
        //    2   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        List<Integer> result = solution.postorderTraversal(root);

        System.out.println("Result: " + result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return helper(root, new ArrayList<>());
    }
    public List<Integer> helper(TreeNode root, List<Integer> list){
        if(root==null) return list;

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);

        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderhelper(root, new ArrayList<>());
    }
    public List<Integer> postorderhelper(TreeNode root, List<Integer> list){
        if(root==null) return list;

        postorderhelper(root.left, list);
        postorderhelper(root.right, list);
        list.add(root.val);

        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderhelper(root, new ArrayList<>());
    }
    public List<Integer> inorderhelper(TreeNode root, List<Integer> list){
        if(root==null) return list;

        list.add(root.val);
        inorderhelper(root.left, list);
        inorderhelper(root.right, list);

        return list;
    }
}
