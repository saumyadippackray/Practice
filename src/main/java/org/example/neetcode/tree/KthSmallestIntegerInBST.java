package org.example.neetcode.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestIntegerInBST {

    public static void main(String[] args) {

        Integer[] arr = {20, 10, 30, 5, 15, 25, 40, 2, 7, 12, 17};



        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        //System.out.println("Before invert:");
        // PrintNode.printLevelWise(root);
        kthSmallest(root,1);

    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> result=new ArrayList<>();
        getResult(root,result);
        return result.get(k-1);
    }

    public static void getResult(TreeNode root,List<Integer> result){
        if(root==null)
            return;

        getResult(root.left,result);
        result.add(root.val);
        getResult(root.right,result);

    }
}
//                 20
//               /    \
//             10      30
//            /  \    /  \
//           5   15  14   40
//          / \  / \
//         2  7 12 17
// In binary tree all small element is in left side and the large element in the right side.
// If we want to get from  small to large first we have to process left elements and after root and after that right elements