class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //we need to find the position of k quickly, so, the first thing we can do is build a hashmap, so that we can find the key and value quickly.
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for(int[] time : times){
            int s = time[0];
            int d = time[1];
            int c = time[2];
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<Pair<Integer, Integer>>());
            }
            map.get(s).add(new Pair(c, d));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        signalReceivedAt[k] = 0;
        while(!queue.isEmpty()){
            int src = queue.poll();
            List<Pair<Integer, Integer>> list = map.get(src);
            if(!map.containsKey(src)){
                continue;
            }
            for(Pair<Integer, Integer> pair : list){
                int cost = pair.getKey();
                int des = pair.getValue();
                int arriveTime = cost + signalReceivedAt[src];
                if(signalReceivedAt[des] > arriveTime){
                    signalReceivedAt[des] = arriveTime;
                    queue.add(des);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            ans = Math.max(signalReceivedAt[i], ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
