package day_055_date_2026_05_24.trees;

public class SubtreeOfAnotherTree {

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
        // Mock Main Tree (root):
        //      3
        //     / \
        //    4   5
        //   / \
        //  1   2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Mock Subtree (subRoot):
        //    4
        //   / \
        //  1   2
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        boolean isSubtree = solution.isSubtree(root, subRoot);

        System.out.println("Is subRoot a subtree of root? " + isSubtree);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case 1: If main tree is empty, subRoot cannot be a subtree
        if (root == null) {
            return false;
        }

        // Check if trees are identical starting from the current node
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Recursively search in the left child OR the right child
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if((p==null && q!=null) || (p!=null && q==null) || p.val!=q.val){
            return false;
        }


        // left same?
        boolean leftSame = isSameTree(p.left, q.left);
        // right same?
        boolean rightSame = isSameTree(p.right, q.right);

        return leftSame && rightSame;
    }
}
