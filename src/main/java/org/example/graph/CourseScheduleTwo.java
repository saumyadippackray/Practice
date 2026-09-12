package org.example.graph;

import java.util.*;

public class CourseScheduleTwo {
    Map<Integer,ArrayList<Integer>> preMap=new HashMap<>();
    Set<Integer> isVisited=new HashSet<>();
    List<Integer> order=new ArrayList<>();

    public static void main(String[] args) {
        CourseScheduleTwo courseScheduleTwo=new CourseScheduleTwo();
        int[][] prerequisites={{1,0}};
                //{{0,1},{1,2},{2,0}};
                //{{1,0}};
        int numCourses=3;
        int[] cyclicResult = courseScheduleTwo.findOrder(numCourses, prerequisites);
        System.out.println("Cycle test result: " + Arrays.toString(cyclicResult));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> preMap=new HashMap<>();

        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int[] prerequisite:prerequisites){
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        HashSet<Integer> cycle=new HashSet<>();
        HashSet<Integer> visited=new HashSet<>();
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,cycle,visited,result,preMap))
                return new int[]{};
        }

        int[] order=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            order[i]=result.get(i);
        }
        return order;
    }

    public boolean dfs(int course, HashSet<Integer> cycle,HashSet<Integer> visited,ArrayList<Integer> result, HashMap<Integer,ArrayList<Integer>> preMap){
        if (cycle.contains(course)){
            return false;
        }
        if(visited.contains(course)){
            return true;
        }
        cycle.add(course);
        for(int c:preMap.get(course)){
            if(!dfs(c,cycle,visited,result,preMap))
                return false;
        }

        cycle.remove(course);
        visited.add(course);
        result.add(course);
        return true;
    }

    public int[] findOrderBootForce(int numCourses, int[][] prerequisites) {
        for (int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfsBootforce(i))
                return new int[0];
        }
        int[] orders=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            orders[i]=order.get(i);
        }
        return orders;
    }

    public boolean dfsBootforce(int course){
        if(preMap.get(course).isEmpty()){
            if(!order.contains(course))
                order.add(course);
            return true;
        }
        else if(isVisited.contains(course)){
            return false;
        }
        isVisited.add(course);
        for(int i:preMap.get(course)){
            if(!dfsBootforce(i))
                return false;
        }

        isVisited.remove(course);
        preMap.put(course,new ArrayList<>());
        if(!order.contains(course))
            order.add(course);
        return true;
    }
}
