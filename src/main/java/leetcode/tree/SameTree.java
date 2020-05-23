package leetcode.tree;

/**
 * https://leetcode.com/problems/same-tree/
 * 100. Same Tree
 */
public class SameTree {
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
//        tn.right.left = new TreeNode(3);

        TreeNode tn2 = new TreeNode(1);
        tn2.left = new TreeNode(2);
        tn2.right = new TreeNode(3);
//        tn.right.left = new TreeNode(3);


        boolean result = isSameTree(tn, tn2);
        System.out.println(result);


    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        printTree(p,s1);
        printTree(q,s2);
        System.out.println(s1);
        System.out.println(s2);
        return s1.toString().equals(s2.toString());

//        return false;
    }

    public static void printTree(TreeNode treeNode, StringBuffer s){
        if(treeNode != null){
            s.append(treeNode.val+",");
            if(treeNode.left!=null || treeNode.right!=null){
                if(treeNode.left!=null){
                    printTree(treeNode.left, s);
                }else{
                    s.append("null,");
                }
                if(treeNode.right!=null){
                    printTree(treeNode.right, s);
                }else{
                    s.append("null,");
                }
            }

        }
    }

}
