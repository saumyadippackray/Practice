package org.example.neetcode.tree;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

            Integer[] arr = {1, 2, 3, null, null, 4};

            // Convert array → tree
            TreeNode root = BuildTree.buildTree(arr);

            System.out.println("Before invert:");
            PrintNode.printLevelWise(root);

            int maxDepth = maxDepth(root);

            System.out.println("\nAfter invert:"+maxDepth);
    }
    public static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
