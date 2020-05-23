package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {
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
        //4 3 2 1

        List<Integer> result = postorderTraversal(tn);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
//        List result = new ArrayList();
//        postorderTraversal(root, result);
//        return result;


        List result = new ArrayList();
        if(root!=null){
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(root);
            while(!s1.isEmpty()){
                TreeNode cur = s1.pop();
                s2.push(cur);

                if(cur.left!=null){
                    s1.push(cur.left);
                }
                if(cur.right!=null){
                    s1.push(cur.right);
                }
            }
            while(!s2.isEmpty()){
                result.add(s2.pop().val);
            }
        }
        return result;

    }

    public static void postorderTraversal(TreeNode cur, List<Integer> list){
        if(cur!=null){
            if(cur.left!=null){
                postorderTraversal(cur.left, list);
            }
            if(cur.right!=null){
                postorderTraversal(cur.right, list);
            }
            list.add(cur.val);
        }
    }
}
