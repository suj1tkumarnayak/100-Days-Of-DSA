package day_068_date_2026_06_07.dailyleetcode;

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CreateABinaryTreeFromDescription {


    public TreeNode createBinaryTree(int[][] descriptions) {
        return null;
    }

    public static void main(String[] args) {
        CreateABinaryTreeFromDescription solution = new CreateABinaryTreeFromDescription();

        // ------------------------------------------------------------
        // Test Case 1: Standard Tree Construction
        // Each row: [parent, child, isLeft] (1 = true for left, 0 = false for right)
        // ------------------------------------------------------------
        /*
        Input descriptions represent this structure:
               20
              /  \
             15   17
            /
           50
        */
        int[][] descriptions1 = {
                {20, 15, 1},  // 20 is parent of 15 (left)
                {20, 17, 0},  // 20 is parent of 17 (right)
                {15, 50, 1}   // 15 is parent of 50 (left)
        };

        System.out.println("--- Test Case 1 ---");
        TreeNode root1 = solution.createBinaryTree(descriptions1);

        if (root1 == null) {
            System.out.println("Returned root is null.");
        } else {
            System.out.println("Expected Root: 20 | Got Root: " + root1.val);
            System.out.println("Expected Root.left: 15 | Got: " + (root1.left != null ? root1.left.val : "null"));
            System.out.println("Expected Root.right: 17 | Got: " + (root1.right != null ? root1.right.val : "null"));
            System.out.println("Expected Root.left.left: 50 | Got: " + (root1.left != null && root1.left.left != null ? root1.left.left.val : "null"));
        }

        // ------------------------------------------------------------
        // Test Case 2: Linear Tree (Linked List style)
        // ------------------------------------------------------------
        /*
               1
                \
                 2
                  \
                   3
        */
        int[][] descriptions2 = {
                {1, 2, 0},  // 1 is parent of 2 (right)
                {2, 3, 0}   // 2 is parent of 3 (right)
        };

        System.out.println("\n--- Test Case 2 ---");
        TreeNode root2 = solution.createBinaryTree(descriptions2);

        if (root2 == null) {
            System.out.println("Returned root is null.");
        } else {
            System.out.println("Expected Root: 1 | Got Root: " + root2.val);
        }
    }
}
