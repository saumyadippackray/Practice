package org.example.neetcode.tree;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

        Integer[] arr = {-15,10,20,null,null,15,5,-5};



        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        //System.out.println("Before invert:");
        // PrintNode.printLevelWise(root);
        System.out.println(maxPathSum(root));

    }
    public static int maxPathSum(TreeNode root) {
        int result[]=new int[]{root.val};
        dfs(root,result);
        return result[0];
    }

    public static int dfs(TreeNode root,int[] result){
        if(root==null)
            return 0;


        int leftMax=Math.max(dfs(root.left,result),0);
        int rightMax=Math.max(dfs(root.right,result),0);

        result[0]=Math.max(result[0],leftMax+rightMax+ root.val );
        
        return root.val+Math.max(leftMax,rightMax);
    }
}
