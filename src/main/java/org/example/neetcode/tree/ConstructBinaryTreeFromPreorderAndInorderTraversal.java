package org.example.neetcode.tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

        Integer[] arr = {20, 10, 30, 5, 15, 25, 40, 2, 7, 12, 17};



        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        //System.out.println("Before invert:");
        PrintNode.printLevelWise(buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));


    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0)
            return null;

        TreeNode root=new TreeNode(preorder[0]);

        int mid=-1;

        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]) {
                mid = i;
                break;
            }
        }

        int[] leftPreOrder=Arrays.copyOfRange(preorder,1,mid+1);
        int[] leftInorder=Arrays.copyOfRange(inorder,0,mid);
        root.left=buildTree(leftPreOrder,leftInorder);

        int[] rightPreOrder=Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int[] rightInorder=Arrays.copyOfRange(inorder,mid+1,inorder.length);
        root.right=buildTree(rightPreOrder,rightInorder);

        //System.out.println(root.val);
        return root;
    }
}
