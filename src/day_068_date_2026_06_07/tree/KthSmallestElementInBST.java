package day_068_date_2026_06_07.tree;

// Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//}

public class KthSmallestElementInBST {

    // thought process do the inorder traversal then return the
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){

        }
        return -1;
    }

    public static void main(String[] args) {
        KthSmallestElementInBST solution = new KthSmallestElementInBST();

        // ------------------------------------------------------------
        // Test Case 1: Standard Balanced Tree
        // Sorted order: [2, 3, 4, 5, 7]
        // ------------------------------------------------------------
        /*
               5
              / \
             3   7
            / \
           2   4
        */
        TreeNode tree1 = new TreeNode(5);
        tree1.left = new TreeNode(3);
        tree1.right = new TreeNode(7);
        tree1.left.left = new TreeNode(2);
        tree1.left.right = new TreeNode(4);

        System.out.println("--- Test Case 1 ---");
        System.out.println("Expected 3rd smallest: 4 | Got: " + solution.kthSmallest(tree1, 3));
        System.out.println("Expected 1st smallest: 2 | Got: " + solution.kthSmallest(tree1, 1));


        // ------------------------------------------------------------
        // Test Case 2: Left-Skewed Tree (Looks like a linked list going left)
        // Sorted order: [10, 20, 30]
        // ------------------------------------------------------------
        /*
               30
              /
             20
            /
           10
        */
        TreeNode tree2 = new TreeNode(30);
        tree2.left = new TreeNode(20);
        tree2.left.left = new TreeNode(10);

        System.out.println("\n--- Test Case 2 ---");
        System.out.println("Expected 2nd smallest: 20 | Got: " + solution.kthSmallest(tree2, 2));


        // ------------------------------------------------------------
        // Test Case 3: Single Node Tree
        // Sorted order: [42]
        // ------------------------------------------------------------
        /*
               42
        */
        TreeNode tree3 = new TreeNode(42);

        System.out.println("\n--- Test Case 3 ---");
        System.out.println("Expected 1st smallest: 42 | Got: " + solution.kthSmallest(tree3, 1));
    }
}
