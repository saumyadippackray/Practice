package org.example.graph.advancegraph;

import java.util.*;

public class MinCosttoConnectPoints {
    public static void main(String[] args) {
        int  points[][] = {{0,0},{2,2},{3,3},{2,4},{4,2}};
        MinCosttoConnectPoints minCosttoConnectPoints=new MinCosttoConnectPoints();
        System.out.println(minCosttoConnectPoints.minCostConnectPoints(points));
    }
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int xi = points[i][0];
            int yi = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int xj = points[j][0];
                int yj = points[j][1];

                int distance = Math.abs(xi - xj) + Math.abs(yi - yj);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{distance, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{distance, i});
            }
        }

            Set<Integer> visited = new HashSet<>();
            Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(k -> k[0]));
            q.add(new int[]{0, 0});
            result = 0;

            while (!q.isEmpty()) {
                int[] node = q.poll();
                int parentNode = node[1];
                int parentCost = node[0];
                System.out.println(visited);
                if(visited.size()==points.length)
                    return result;
                if (visited.contains(parentNode)) {
                    continue;
                }

                result = result + parentCost;
                visited.add(parentNode);
                for (int[] neighbour : adj.getOrDefault(node[1],new ArrayList<>())) {
                    int neiNode = neighbour[1];
                    int neiCost = neighbour[0];

                    if (!visited.contains(neiNode)) {
                        q.offer(new int[]{neiCost, neiNode});
                    }
                }
            }
        return result;

    }
}
