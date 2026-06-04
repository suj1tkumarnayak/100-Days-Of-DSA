package day_068_date_2026_06_07.tree;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, or if we find either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Look for p and q in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Look for p and q in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, it means p is on one side and q is on the other
        // So, the current root is their lowest common ancestor
        if (left != null && right != null) {
            return root;
        }

        // If one side is null, it means both nodes are on the other side
        return (left != null) ? left : right;
    }
}
