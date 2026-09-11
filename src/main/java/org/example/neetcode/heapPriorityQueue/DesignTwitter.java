package org.example.neetcode.heapPriorityQueue;

import java.util.*;

public class DesignTwitter {
    public static void main(String[] args) {
        DesignTwitter twitter=new DesignTwitter();
        twitter.postTweet(1, 101); // User 1 posts a new tweet with id = 10.
        twitter.postTweet(1, 102); // User 2 posts a new tweet with id = 20.
        twitter.follow(2, 1);     // User 1 follows user 2.

        System.out.println(twitter.getNewsFeed(2));   // User 2's news feed should only contain their own tweets -> [20].
        twitter.unfollow(1, 2);   // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(2));   // User 2's news feed should still only contain their own tweets -> [20].
    }
    Map<Integer, Set<Integer>> followerMap;
    int count;
    Map<Integer,List<int[]>> tweetMap;
    public DesignTwitter() {
        count=0;
        followerMap=new HashMap<>();
        tweetMap=new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        count--;
        tweetMap.computeIfAbsent(userId,a->new ArrayList<>()).add(new int[]{count,tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        List<Integer> result=new ArrayList<>();
        followerMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        Set<Integer> followees=followerMap.get(userId);// userid should see their own post in their feed

        for (Integer followee:followees){
            if(tweetMap.containsKey(followee)) {
                List<int[]> tweets = tweetMap.get(followee);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                queue.offer(new int[]{tweet[0], tweet[1], followee, index});
            }
        }

        while (result.size()<10 && !queue.isEmpty()){
            int[] current=queue.poll();
            result.add(current[1]);
            int followeeId=current[2];
            int index=current[3]-1;

            if(index>=0) {
                int[] nextTweet=tweetMap.get(followeeId).get(index);
                queue.offer(new int[]{nextTweet[0], nextTweet[1], followeeId, index});
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
//           followerMap.putIfAbsent(followerId,new HashSet<>());
//           followerMap.get(followerId).add(followeeId);
           followerMap.computeIfAbsent(followerId,a->new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
          followerMap.computeIfPresent(followerId,(k,v)->{
              v.remove(followeeId);
              return v;
          });
    }
}
