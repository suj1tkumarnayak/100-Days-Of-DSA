package day_068_date_2026_06_07.tree;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validBST(TreeNode root, long min, long max) {
        //if(root.left==null && root.right==null) return true;
        if(root==null) return true;

        if(root.val<=min || root.val>=max){
            return false;
        }

        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidateBST validator = new ValidateBST();

        /*
               5
              / \
             1   7
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);

        // This should print true once your code is complete
        System.out.println("Is valid BST: " + validator.isValidBST(root));
    }
}
