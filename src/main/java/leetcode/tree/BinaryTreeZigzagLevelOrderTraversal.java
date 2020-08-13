package leetcode.tree;

import java.util.*;

/**
 *  https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *  103. Binary Tree Zigzag Level Order Traversal
 *  Medium
 *
 *  ZigZag打印 需用一个queue记录，用一个stack暂存
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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

        List<List<Integer>> result = zigzagLevelOrder(tn);
        System.out.println(result.toString());

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue queue = new LinkedList<TreeNode>();
        Stack stack = new Stack<Integer>();
        boolean clockwise = false;
        TreeNode lineStartNode = root;
        if(root!=null){
            queue.offer(root);
            List<Integer> line = null;
            while(!queue.isEmpty()){
                TreeNode tn = (TreeNode) queue.poll();

                if(tn == lineStartNode){
                    if(!clockwise){
                        while(!stack.isEmpty()){
                            line.add((Integer)stack.pop());
                        }
                    }
                    if(line != null){
                        result.add(line);
                    }
                    line = new ArrayList<Integer>();
                    lineStartNode = null;
                    clockwise = clockwise == true ? false : true;
                }
                if(clockwise){
                    line.add(tn.val);
                }else{
                    stack.push(tn.val);
                }

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
            if(!clockwise){
                while(!stack.isEmpty()){
                    line.add((Integer)stack.pop());
                }
            }
            if(line != null){
                result.add(line);
            }

        }
        return result;
    }
}
