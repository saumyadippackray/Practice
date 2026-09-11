package org.example.neetcode.tree;

public class SubTreeOfAnotherTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        Integer[] arr2 = {2,4,5};


        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);
        TreeNode root2 = BuildTree.buildTree(arr2);

        System.out.println("Before invert:");
        PrintNode.printLevelWise(root);
        System.out.println(isSubTree(root,root2));
    }
    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(subRoot==null)
            return true;
        if(isSameTree(root,subRoot))
            return true;
        return isSubTree(root.right,subRoot) || isSubTree(root.left,subRoot);
    }

    public static boolean isSameTree(TreeNode node1,TreeNode node2){
        if(node1==null & node2==null)
            return true;
        if((node1!=null && node2 !=null && node1.val==node2.val)) {
            return isSameTree(node1.left,node2.left)&&isSameTree(node1.right,node2.right);
        }
        else
            return false;
    }
}
