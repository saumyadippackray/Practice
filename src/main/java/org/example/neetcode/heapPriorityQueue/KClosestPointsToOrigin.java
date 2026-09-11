package org.example.neetcode.heapPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int[] point:points){
            Integer distance= (point[0]*point[0])+(point[1]*point[1]);
            queue.offer(new int[]{distance,point[0],point[1]});
        }
        int[][] results = new int[k][2];
        for(int i=0;i<k;i++){
            int[] result=queue.poll();
            results[i]=new int[]{result[1],result[2]};
        }
        return results;
    }
}
