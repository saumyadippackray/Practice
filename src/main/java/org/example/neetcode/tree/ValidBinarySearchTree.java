package org.example.neetcode.tree;

public class ValidBinarySearchTree {
    public static void main(String[] args) {

            Integer[] arr = {2,1,3};



            // Convert array → tree
            TreeNode root = BuildTree.buildTree(arr);

            System.out.println("Before invert:");
            // PrintNode.printLevelWise(root);
            System.out.println(isValidBST(root));

    }
    public static boolean isValidBST(TreeNode root) {
     return checkBinaryTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean checkBinaryTree(TreeNode node,long left,long right){
        if (node==null)
            return true;
        if(!(node.val>left && node.val<right)){
            return false;
        }
        return checkBinaryTree(node.left,left,node.val) &&
                checkBinaryTree(node.right,node.val,right);
    }
}
//                 20
//               /    \
//             10      30
//            /  \    /  \
//           5   15  14   40
//          / \  / \
//         2  7 12 17
//30- left-20,right-+infinity
//14- left-20,right-30