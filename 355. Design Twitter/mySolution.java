import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Twitter {

    private Map<Integer, User> userMap;
    private static int timeStamp = 0;

    private class Tweet {
        public int id;
        public int time;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
        }
    }

    private class User {
        public id;
        public Set<Integer> followed;
        public List<Tweet> tweets;
        
        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweets = new LinkedList<>();
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            tweets.add(new Tweet(id));
        }
    }
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
        timestamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = userMap.get(userId);
        user.post
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (UserId_TweetId.containsKey(userId)) {
            List<Integer> list = UserId_TweetId.get(userId);
            for(int i = list.size()-1; i >= list.size() - 10; i --) {
                res.add(list.get(i));
                if (i == 0) break;
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (UserId_FollowId.containsKey(followerId)) {
            HashSet<Integer> set = UserId_FollowId.get(followerId);
            if (set.contains(followeeId)) {
                return;
            } else {
                set.add(followeeId);
            }
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(followeeId);
            UserId_FollowId.put(followerId, set);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (UserId_FollowId.containsKey(followerId)) {
            HashSet<Integer> set = UserId_FollowId.get(followerId);
            if (!set.contains(followeeId)) {
                return;
            } else {
                set.remove(followeeId);
            }
        } else {
            return;
        }       
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */