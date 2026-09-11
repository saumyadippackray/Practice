package org.example.neetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {

        Integer[] arr = {1,2,3,null,null,4,5};



        // Convert array → tree
        TreeNode root = BuildTree.buildTree(arr);

        //System.out.println("Before invert:");
        // PrintNode.printLevelWise(root);
        System.out.println(serialize(root));
        PrintNode.printLevelWise(deserialize(serialize(root)));

    }
    public static String serialize(TreeNode root) {
        List<String> result=new ArrayList<>();
        dfsSerialize(root,result);
        return String.join(",",result);
    }

    public static void dfsSerialize(TreeNode root, List<String> result){
        if(root==null){
            result.add("N");
            return;
        }
        result.add(String.valueOf(root.val));
        dfsSerialize(root.left,result);
        dfsSerialize(root.right,result);

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsDeserialize(vals, i);
    }

    public static TreeNode dfsDeserialize(String[] vals,int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode node=new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left=dfsDeserialize(vals,i);
        node.right=dfsDeserialize(vals,i);
        return node;
    }
}
