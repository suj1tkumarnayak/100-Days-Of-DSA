package day_055_date_2026_05_24.trees;

public class LowestCommonAncestorOfABinaryTree {

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
        //        3
        //       / \
        //      5   1
        //     / \
        //    6   2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        // Targets: Find LCA of node 5 and node 1
        TreeNode p = root.left;       // Node 5
        TreeNode q = root.right;      // Node 1

        LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + (lca != null ? lca.val : "null"));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TODO: Implement your Lowest Common Ancestor algorithm here
        return null;
    }
}
