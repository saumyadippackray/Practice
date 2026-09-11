package org.example.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Create edges
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node2.neighbors.add(node4);

        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node2);
        node4.neighbors.add(node3);

    }

    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node> cloneGraph=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        cloneGraph.put(node,new Node(node.val));

        while (!q.isEmpty()){
            Node n=q.poll();
            for (Node neighbor:n.neighbors) {
                if (!cloneGraph.containsKey(neighbor)) {
                    cloneGraph.put(neighbor,new Node(neighbor.val));
                    q.add(neighbor);
                }
                cloneGraph.get(n).neighbors.add(cloneGraph.get(neighbor));
            }
        }
        return cloneGraph.get(node);
    }
}
