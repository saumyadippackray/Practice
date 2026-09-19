package org.example.graph.advancegraph;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
         int[][] times=new int[][]{{1,2,1},{2,3,1},{1,4,4},{3,4,1}};
         int n = 4;
         int k = 1;
//            int[][] times=new int[][]{{1,2,1},{2,3,1}};
//            int n = 3;
//            int k = 2;
         NetworkDelayTime networkDelayTime=new NetworkDelayTime();
         System.out.println(networkDelayTime.networkDelayTimeWithDfs(times,n,k));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> nei=new HashMap<>();

        for(int[] time:times){
            nei.computeIfAbsent(time[0],i->new ArrayList<>()).add(new int[]{time[1],time[2]});;
        }

        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        q.add(new int[]{0,k});
        int weight=0;
        Set<Integer> visited=new HashSet<>();
        while (!q.isEmpty()){
            int[] curr=q.poll();//0,1
            int time=curr[0];
            int node=curr[1];
            if(visited.contains(node)){ //i=1,3
                continue;
            }
            visited.add(node);
            weight=Math.max(weight,time);
            for(int[] i:nei.getOrDefault(node,Collections.emptyList())){
                int NextNodeTime=i[1];
                int nextNode=i[0];
                if(!visited.contains(nextNode)){
                    q.offer(new int[]{NextNodeTime+time,nextNode});
                }
            }
        }
        System.out.println(visited);
        if(visited.size()==n)
            return weight;
        else
            return -1;
    }

    public int networkDelayTimeWithDfs(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> nei=new HashMap<>();

        for(int[] time:times){
            nei.computeIfAbsent(time[0],i->new ArrayList<>()).add(new int[]{time[1],time[2]});;
        }

       Map<Integer,Integer> dist=new HashMap<>();
       for(int i=1;i<=n;i++){
           dist.put(i,Integer.MAX_VALUE);
       }
       dfs(k,0,nei,dist);
       int res=Collections.max(dist.values());
       System.out.println(dist.values());
       if(res==Integer.MAX_VALUE)
           return -1;
       else
           return res;
    }

    public void dfs(int node,int time, Map<Integer, List<int[]>> nei,Map<Integer,Integer> dist){
        if(time>=dist.get(node))
            return;
        dist.put(node,time);
        if(!nei.containsKey(node)) return;
        for(int[] i:nei.get(node)){
            dfs(i[0],time+i[1],nei,dist);
        }
    }
}
