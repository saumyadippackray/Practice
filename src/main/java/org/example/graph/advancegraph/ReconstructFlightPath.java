package org.example.graph.advancegraph;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class ReconstructFlightPath {
    public static void main(String[] args) {
        List<List<String>> tickets = List.of(
                List.of("HOU", "JFK"),
                List.of("SEA", "JFK"),
                List.of("JFK", "SEA"),
                List.of("JFK", "HOU")
        );

        ReconstructFlightPath reconstructFlightPath=new ReconstructFlightPath();
        System.out.println(reconstructFlightPath.findItineraryHierholzerAlgorithm(tickets));
    }
    public List<String> findItineraryHierholzerAlgorithm(List <List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj=new HashMap<>();
        for(List<String> ticket:tickets){
            adj.computeIfAbsent(ticket.get(0),k->new PriorityQueue<>()).add(ticket.get(1));
        }

        Stack<String> stack=new Stack<>();
        LinkedList<String> res=new LinkedList<>();
        stack.add("JFK");
        while (!stack.isEmpty()){
            String curr=stack.peek();
            if(!adj.containsKey(curr) || adj.get(curr).isEmpty()){
                res.addFirst(stack.pop());
            }
            else {
                stack.push(adj.get(curr).poll());
            }
        }
        return res;
    }
    public List<String> findItinerary(List <List<String>> tickets) {
        Map<String, ArrayList<String>> adj=new HashMap<>();
        for(List<String> ticket:tickets){
            adj.putIfAbsent(ticket.get(0),new ArrayList<>());
        }
        List<List<String>> mutableTickets = new ArrayList<>(tickets);

// 2. Sort the mutable list
        mutableTickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        for(List<String > ticket:mutableTickets){
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> result=new ArrayList<>();
        result.add("JFK");
        if(!dfs("JFK",adj,result,tickets.size()+1)){
            return new ArrayList<>();
        }
        return result;
    }

    public boolean dfs(String node, Map<String, ArrayList<String>> adj,List<String> result,int targetLen){
      if(result.size()==targetLen)
          return true;
      if(!adj.containsKey(node))
          return false;
      List<String> temp=adj.get(node);
      for(int i=0;i<temp.size();i++){
          String nextNode=temp.get(i);
          result.add(nextNode);
          temp.remove(i);
          if(dfs(nextNode,adj,result,targetLen))
              return true;
          result.remove(result.size()-1);
          temp.add(i,nextNode);
      }
      return false;
    }


}
