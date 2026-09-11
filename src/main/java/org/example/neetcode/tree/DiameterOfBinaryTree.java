package org.example.neetcode.tree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,null,2,3,4,5};

        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        System.out.println("Before invert:");
        PrintNode.printLevelWise(root);
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        getResult(root, res);
        return res[0];

    }
    static int getResult(TreeNode rootNode,int[] result){
        if(rootNode==null)
            return 0;
        int left=getResult(rootNode.left,result);
        int right=getResult(rootNode.right,result);
        result[0]=Math.max(result[0],(left+right));
        return 1+Math.max(left,right);
    }
}
