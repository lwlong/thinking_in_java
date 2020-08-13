package leetcode.tree;

/**
 * https://leetcode.com/problems/path-sum/
 * 112. Path Sum 路经总和
 * Easy
 */
public class PathSum {
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
//        TreeNode tn = new TreeNode(1);
//        tn.left = new TreeNode(4);
//        tn.right = new TreeNode(2);
//        tn.right.left = new TreeNode(3);

        TreeNode tn = new TreeNode(-2);
//        tn.left = new TreeNode(4);
        tn.right = new TreeNode(-3);
//        tn.right.left = new TreeNode(3);

        boolean result = hasPathSum(tn, -5);
        System.out.println(result);

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null ){
            return false;
        }
        if(root.val == sum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
//        return false;
    }

}
