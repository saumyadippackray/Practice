package org.example.neetcode.tree;

public class SameBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        Integer[] arr2 = {1,2,5,6};


        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);
        TreeNode root2 = BuildTree.buildTree(arr2);

        System.out.println("Before invert:");
        PrintNode.printLevelWise(root);
        System.out.println(isSameTree(root,root2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
       if (p==null & q==null)
           return true;

       if(p!=null && q!=null && p.val== q.val)
           return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
       else
           return false;
    }
//    Node	    Compared?	Reason
//    1 vs 1	✔️ Yes	    Root
//    2 vs 2	✔️ Yes	    Left subtree
//    null vs 6	✔️ Yes	    Mismatch → return false
//    3 vs 5	❌ No	    Short-circuited
//❗ Since the left subtree returned false, Java will not continue to evaluate the right subtree of the root due to short-circuit AND (&&).

    public static boolean checkSameBinaryTreeNew(TreeNode p,TreeNode q){
        if(p==null && q==null)
            return true;

        checkSameBinaryTreeNew(p.left,q.left);
        checkSameBinaryTreeNew(p.right,q.right);
//        System.out.println("p.left"+p.left.val+"q.left"+q.left.val);
//        System.out.println("p.right"+p.right.val+"q.right"+q.right.val);
        if(p!=null && q!=null && p.val!=q.val)
            return false;
        else
            return true;
//        if(p.right!=null && q.right!=null && p.right!=q.right)
//            isSame[0]=false;
    }
    public static void checkSameBinaryTree(TreeNode p,TreeNode q,Boolean[] isSame){
        if(p==null && q==null)
            return;

        checkSameBinaryTree(p.left,q.left,isSame);
        checkSameBinaryTree(p.right,q.right,isSame);
//        System.out.println("p.left"+p.left.val+"q.left"+q.left.val);
//        System.out.println("p.right"+p.right.val+"q.right"+q.right.val);
        if(p!=null && q!=null && p.val!=q.val)
            isSame[0]=false;
//        if(p.right!=null && q.right!=null && p.right!=q.right)
//            isSame[0]=false;
    }
}
