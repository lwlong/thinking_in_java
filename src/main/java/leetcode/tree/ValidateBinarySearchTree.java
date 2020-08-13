package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 98. Validate Binary Search Tree
 * Medium
 *
 */
public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean result = validateBinarySearchTree.isValidBST(treeNode);
        System.out.println(result);

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        InOrderTraversal(root, values);
        System.out.println(values);

        for(int i=0; i<values.size()-1; i++){
                if(values.get(i) >= values.get(i+1)){
                    return false;
                }
        }

        return true;

    }

    //中序遍历
    public void InOrderTraversal(TreeNode treeNode, List list)
    {
        if(treeNode != null) {
            InOrderTraversal(treeNode.left, list);
            list.add(treeNode.val);
            InOrderTraversal(treeNode.right, list);
        }
    }

//[10,5,15,null,null,6,20]  false
//[3,1,5,0,2,4,6]  true
//[3,1,5,0,2,4,6,null,null,null,3] false
//[3,null,30,10,null,null,15,null,45] false
//    public boolean isValidBST(TreeNode root) {
//        String values = "";
//        Stack stack=new Stack();
//        if(root!=null){
//            stack.push(root);
//        }
//        while(!stack.empty()){
//            TreeNode treeNode = (TreeNode) stack.peek();
//            stack.pop();
//            if(values.contains(treeNode.val+",")){
//                return false;
//            }
//            values += treeNode.val+",";
//            if(treeNode.left != null){
//                if(treeNode.val <= treeNode.left.val){
//                    return false;
//                }
//                if(treeNode.left.left!=null){
//                    if(treeNode.val <= treeNode.left.left.val){
//                        return false;
//                    }
//                }
//                if(treeNode.left.right!=null){
//                    if(treeNode.val <= treeNode.left.right.val){
//                        return false;
//                    }
//                }
//                stack.push(treeNode.left);
//
//            }
//            if(treeNode.right != null){
//                if(treeNode.val >= treeNode.right.val){
//                    return false;
//                }
//                if(treeNode.right.left!=null){
//                    if(treeNode.val >= treeNode.right.left.val){
//                        return false;
//                    }
//                }
//                if(treeNode.right.right!=null){
//                    if(treeNode.val >= treeNode.right.right.val){
//                        return false;
//                    }
//                }
//                stack.push(treeNode.right);
//
//
//            }
//        }
//        return true;
//    }




}
