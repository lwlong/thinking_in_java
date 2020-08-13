package leetcode.tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 111. Minimum Depth of Binary Tree 最小深度
 * Easy
 */
public class MinimumDepthOfBinaryTree {
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
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);
        tn.right.left = new TreeNode(3);

        int result = minDepth(tn);
        System.out.println(result);
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
    }


}
