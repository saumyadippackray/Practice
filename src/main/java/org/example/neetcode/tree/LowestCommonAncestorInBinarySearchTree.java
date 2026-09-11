package org.example.neetcode.tree;

public class LowestCommonAncestorInBinarySearchTree {
    public static void main(String[] args) {
       // Integer[] arr = {5,3,8,1,4,7,9,null,2};
        Integer[] arr = {  5,3,8,1,4,7,9,null,2};



        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        System.out.println("Before invert:");
        //PrintNode.printLevelWise(root);
        System.out.println(lowestCommonAncestor(root,new TreeNode(3),new TreeNode(4)).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null){
            return null;
        }
        if(Math.max(p.val,q.val)<root.val){
           return lowestCommonAncestor(root.left,p,q);
        }
        else if(Math.min(p.val, q.val)> root.val){
           return lowestCommonAncestor(root.right,p,q);
        }
        else {
            return root;
        }
    }
}
