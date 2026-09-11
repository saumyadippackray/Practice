package org.example.tree.BinaryTree;

import org.w3c.dom.Node;

public class BuildBinaryTree {
    static class BinaryNode{
        int value;
        BinaryNode leftNode;
        BinaryNode rightNode;

        BinaryNode(int value){
            this.value=value;
            leftNode=null;
            rightNode=null;
        }

        @Override
        public String toString() {
            return "BinaryNode{" +
                    "value=" + value +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static BinaryNode buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1)
                return null;
            BinaryNode binaryNode=new BinaryNode(nodes[idx]);
            binaryNode.leftNode=buildTree(nodes);
            binaryNode.rightNode=buildTree(nodes);
            return  binaryNode;
        }
    }
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        System.out.println(BinaryTree.buildTree(node));
    }
}
