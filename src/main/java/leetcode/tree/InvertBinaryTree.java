package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  https://leetcode.com/problems/invert-binary-tree/
 *  226. Invert Binary Tree
 */
public class InvertBinaryTree {
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
        TreeNode tn = new TreeNode(4);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(7);
        tn.left.left = new TreeNode(1);
        tn.left.right = new TreeNode(3);
        tn.right.left = new TreeNode(6);
        tn.right.right = new TreeNode(9);

        System.out.println(levelOrder(tn).toString());
        TreeNode result = invertTree(tn);
        System.out.println(levelOrder(result).toString());

    }

    public static TreeNode invertTree(TreeNode root) {
        if(root!=null){
            if(root.left!=null){
                invertTree(root.left);
            }
            if(root.right!=null){
                invertTree(root.right);
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        return root;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue queue = new LinkedList<TreeNode>();
        TreeNode lineStartNode = root;
        if(root!=null){
            queue.offer(root);
            List<Integer> line = null;
            while(!queue.isEmpty()){
                TreeNode tn = (TreeNode) queue.poll();
                if(tn == lineStartNode){
                    if(line!=null){
                        result.add(line);
                    }
                    line = new ArrayList<Integer>();
                    lineStartNode = null;
                }
                line.add(tn.val);
                if(tn.left!=null){
                    queue.offer(tn.left);
                    if(lineStartNode == null){
                        lineStartNode = tn.left;
                    }
                }
                if(tn.right!=null){
                    queue.offer(tn.right);
                    if(lineStartNode == null){
                        lineStartNode = tn.right;
                    }
                }

            }
            result.add(line);
        }

        return result;
    }
}
