package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 94. Binary Tree Inorder Traversal 中序遍历
 * Medium
 *
 */
public class BinaryTreeInorderTraversal {

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

        List<Integer> result = inorderTraversal(tn);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
//        List result = new ArrayList();
//        inorderTraversal(root, result);
//        return result;



//        List result = new ArrayList();
//        Stack<TreeNode> stack = new Stack<>();
//        if(root != null){
//            stack.push(root);
//        }
//        while(!stack.isEmpty()){
//            TreeNode cur = stack.pop();
//            if(cur.left==null && cur.right==null){
//                result.add(cur.val);
//            }else{
//                if(cur.right != null){
//                    stack.push(cur.right);
//                }
//                stack.push(new TreeNode(cur.val));
//                if(cur.left != null){
//                    stack.push(cur.left);
//                }
//            }
//        }
//        return result;



        List result = new ArrayList();
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while(root != null || !stack.isEmpty()){
                if(root != null){
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    result.add(root.val);
                    root = root.right;
                }
            }
        }
        return result;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> list){
        if(root != null){
            if(root.left != null){
                inorderTraversal(root.left, list);
            }

            list.add(root.val);

            if(root.right != null){
                inorderTraversal(root.right, list);
            }
        }

    }
}
