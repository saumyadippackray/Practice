package org.example.neetcode.tree;

import com.sun.source.tree.Tree;
import org.example.neetcode.linkedList.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    static List<Integer> result=new ArrayList();
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};



        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        System.out.println("Before invert:");
        PrintNode.printLevelWise(root);
        System.out.println(rightSideViewBFS(root));
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideViewBFS(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            Integer rightSide = null;
            for (int i= queue.size();i>0;i--){
                TreeNode poll=queue.poll();
                if(poll!=null){
                rightSide=poll.val;
                queue.add(poll.left);
                queue.add(poll.right);
                }
            }
            if(rightSide!=null){
                result.add(rightSide);
            }
        }
        return result;
    }
    public static List<Integer> rightSideView(TreeNode root) {
        def(root,0);
        return result;
    }
    public static void def(TreeNode node,int level){
        if(node==null)
            return;
        if(result.size()==level)
            result.add(node.val);
        // How it is working -
        // 1st the value of root will be 1 and level will be 0 def(1,0) size of result is 0 then  if(result.size()==level) e will add 1 to the list
        // 2nd the value of root will be 3 and level will be 1 def(3,1) size of result is 1 then  if(result.size()==level) e will add 3 to the list
        // 2nd the value of root will be 2 and level will be 1 def(2,1) size of result is 2 then  if(result.size()!=level) e will not add 2 to the list
        // we want the right most element from each level that's why we are doing this
        // if(result.size()==level)
        //            result.add(node.val);
        // We are adding from the right side
        def(node.right,level+1);
        def(node.left,level+1);
    }

}
