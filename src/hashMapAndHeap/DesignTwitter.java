package hashMapAndHeap;

import java.util.*;

public class DesignTwitter {

}

class User {
    Set<Integer> following;
    Set<Integer> followers;
    TreeSet<int[]> allPosts;
    HashSet<int[]> selfPosts;

    User(int userId) {
        this.following = new HashSet<>();
        this.following.add(userId);
        this.followers = new HashSet<>();
        this.allPosts = new TreeSet<>((a, b) -> b[1] - a[1]);
        this.selfPosts = new HashSet<>();
    }
}

class Twitter {

    int tweets[];
    User[] users;
    int time;

    public Twitter() {
        this.time = 0;
        this.tweets = new int[10001];
        this.users = new User[501];
    }

    public void postTweet(int userId, int tweetId) {
        // get the user
        User current = users[userId];
        if (current == null) {
            current = new User(userId);
            users[userId] = current;
        }
        // mark the tweet
        tweets[tweetId] = userId; 
        // add post in the current user
        int[] post = new int[] { tweetId, time++ };
        current.allPosts.add(post);
        current.selfPosts.add(post);
        // add the post in the allPosts of its followers
        for (int follower : current.followers) {
            users[follower].allPosts.add(post);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>(10);
        User current = users[userId];
        if (current == null) {
            return ans;
        }
        for (int[] post : current.allPosts) {
            int user = tweets[post[0]];
            if (current.following.contains(user)) {
                ans.add(post[0]);
            }
            if (ans.size() == 10) {
                break;
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        User toFollow = users[followeeId];
        User follower = users[followerId];
        if (follower == null) {
            follower = new User(followerId);
            users[followerId] = follower;
        }
        if (toFollow == null) {
            toFollow = new User(followeeId);
            users[followeeId] = toFollow;
        }
        follower.following.add(followeeId);
        follower.allPosts.addAll(toFollow.selfPosts);
        toFollow.followers.add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        User toFollow = users[followeeId];
        User follower = users[followerId];
        toFollow.followers.remove(followerId);
        follower.following.remove(followeeId);
    }

}