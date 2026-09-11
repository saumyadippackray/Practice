package org.example.graph;

import java.util.*;

public class CourseSchedule {
    Map<Integer,ArrayList<Integer>> preMap=new HashMap<>();
    Set<Integer> isVisited=new HashSet<>();
    public static void main(String[] args) {
        int numCourses = 1;
        int[][] prerequisites = {{0,0}};
        CourseSchedule schedule=new CourseSchedule();
        System.out.println(schedule.canFinish(numCourses,prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int[] p:prerequisites){
            preMap.get(p[0]).add(p[1]);
        }
        for(int i=0;i<numCourses;i++)
        {
            if(!dfs(i))
                return false;
        }
        return true;
    }

    public boolean dfs(int cur){
        if(preMap.get(cur).isEmpty())
            return true;
        else if (isVisited.contains(cur)) {
            return false;
        }
        isVisited.add(cur);
        for(Integer i:preMap.get(cur)){
            if(!dfs(i))
                return false;
        }
        isVisited.remove(cur);
        preMap.put(cur,new ArrayList<>());
        return true;
    }

}
