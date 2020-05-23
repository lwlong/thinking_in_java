package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {
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

        List<Integer> result = preorderTraversal(tn);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
//        List result = new ArrayList();
//        preorderTraversal(root, result);
//        return result;

        List result = new ArrayList();
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
                if(root.right!=null){
                    stack.push(root.right);
                }
                if(root.left!=null){
                    stack.push(root.left);
                }
            }
        }
        return result;

    }


    public static void preorderTraversal(TreeNode cur, List<Integer> result){
        if(cur != null){
            result.add(cur.val);
            if(cur.left!=null){
                preorderTraversal(cur.left, result);
            }
            if(cur.right!=null){
                preorderTraversal(cur.right, result);
            }
        }
    }
}
