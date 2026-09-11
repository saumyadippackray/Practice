package org.example.neetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class CountGoodNodesInBinaryTree {
    static List<Integer> result=new ArrayList<>();

    public static void main(String[] args) {
        Integer[] arr = {2,1,1,3,null,1,5};



        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        System.out.println("Before invert:");
       // PrintNode.printLevelWise(root);
        System.out.println(goodNodes(root));
    }
    public static int goodNodes(TreeNode root) { // My solution
//        def(root, root.val);
//        return result.size();
        return defWithOutExtraVeriable(root, root.val);
    }

    public static void def(TreeNode node,int maxValue){
        if (node==null)
            return;
        int newMaxValue=maxValue;
        if(node.val>=maxValue){
            result.add(node.val);
            newMaxValue= node.val;
        }
        def(node.left,newMaxValue);
        def(node.right,newMaxValue);
    }

    public static int defWithOutExtraVeriable(TreeNode node,int maxValue){
        if (node==null)
            return 0;
        int res=node.val>=maxValue?1:0;
        if(node.val>=maxValue) {
            maxValue = node.val;
        }
//        if(node.val>=maxValue){
//            result.add(node.val);
//            newMaxValue= node.val;
//        }
        res=res+defWithOutExtraVeriable(node.left,maxValue);
        res=res+defWithOutExtraVeriable(node.right,maxValue);
        return res;
    }
}
