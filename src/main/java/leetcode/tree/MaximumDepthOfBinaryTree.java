package leetcode.tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
 * 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {
    public static class TreeNode {
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
    public static void main(String[] args) {
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(4);
        tn.right = new TreeNode(2);
        tn.right.left = new TreeNode(3);
        tn.right.right = new TreeNode(6);

        int result = maxDepth(tn);
        System.out.println(result);
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
//        int leftDepth = root.left==null ? 0 : maxDepth(root.left)+1;
//        int rightDepth = root.right==null ? 0 : maxDepth(root.right)+1;
//        return Math.max(leftDepth, rightDepth);
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
