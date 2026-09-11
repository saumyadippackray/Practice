package org.example.neetcode.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    static List<List<Integer>> result=new ArrayList<>();


    public static List<List<Integer>> levelOrderWithDFS(TreeNode root) {
        def(root,0);
        return result;
    }

    public static void def(TreeNode node,int level){
        if(node==null)
            return;
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        def(node.left,level+1);
        def(node.right, level+1);
    }

    //DFS
    // 1,0 -> [1]
    //2,1           3,1  ->[2,3]
    //4,2  5,2      6,2  7,2->[4,5,6,7]
    // We have to return the level with every step and add values into the array according to the level
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> level=new ArrayList<>();

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            ArrayList<Integer> list=new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){ //int i=0;i< queue.size();i++ is wrong because queue size is increase every traversal that's why queue.size() is evaluated once
//                That value represents:
//👉 Number of nodes at the current level
//                Even though new nodes are added, they are processed in the next iteration of while loop
                TreeNode node=queue.poll();
                if(node!=null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(list.size()>0){
                level.add(list);
            }
        }
        return level;
    }
}

//1,2,3,4,5,6,7
//1
//2,3 -[1],
//3,4,5 - [1],[2]
