class Twitter {
    private class Tweet{
        int id;
        int timestamp;
        private Tweet next;
        public Tweet(int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }
    }
    private Map<Integer, Set<Integer>> followings;
    private HashMap<Integer, Tweet> twitter;
    private static int timestamp = 0;
    private static PriorityQueue<Tweet> maxHeap;
    public Twitter() {
        followings = new HashMap();
        twitter = new HashMap();
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if(twitter.containsKey(userId)){
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        }
        else{
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if(twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }
        Set<Integer> followingList = followings.get(userId);
        if(followingList != null && followingList.size() > 0){
            for(Integer followingId : followingList){
                Tweet tweet = twitter.get(followingId);
                if(tweet != null){
                    maxHeap.offer(tweet);
                }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int cnt = 0;
        while(!maxHeap.isEmpty() && cnt < 10){
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if(head.next != null){
                maxHeap.offer(head.next);
            }
            cnt++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId){
            return;
        }
        Set<Integer> followingList = followings.get(followerId);
        if(followingList == null){
            Set<Integer> init = new HashSet();
            init.add(followeeId);
            followings.put(followerId, init);
        }
        else{
            if(followingList.contains(followeeId)){
                return;
            }
            followingList.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followeeId == followerId){
            return;
        }
        Set<Integer> followingList = followings.get(followerId);
        if(followingList == null){
            return;
        }
        followingList.remove(followeeId);
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
