package org.example.neetcode.tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,null,null,4};

        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        System.out.println("Before invert:");
       // PrintNode.printLevelWise(root);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        Boolean[] res = new Boolean[]{true};

        checkBalanced(root, res);
        return res[0];


    }

    public static int checkBalanced(TreeNode root,Boolean[] status){
        if(root==null)
            return 0;
        int leftLength=checkBalanced(root.left,status);
        int rightLength=checkBalanced(root.right,status);
        if((leftLength>rightLength+1 || rightLength>leftLength+1) && status[0]==true){
            status[0]=false;
        }
        return 1+Math.max(leftLength,rightLength);
    }
}
