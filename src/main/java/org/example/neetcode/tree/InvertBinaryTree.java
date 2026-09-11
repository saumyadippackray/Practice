package org.example.neetcode.tree;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)
                )
        );

        System.out.println("Before invert:");
        PrintNode.printLevelWise(root);
        System.out.println();

        root = invertTree(root); // calling your function

        System.out.println("After invert:");
        PrintNode.printLevelWise(root);
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
