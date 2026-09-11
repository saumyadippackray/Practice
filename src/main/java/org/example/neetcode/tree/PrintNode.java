package org.example.neetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNode {
    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    public static void printLevelWise(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();      // number of nodes in this level

            while (size-- > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            System.out.println();  // Move to next level
        }
    }
}
