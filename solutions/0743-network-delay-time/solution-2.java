class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> adjacents = new HashMap<>();
        for(int[] time : times){
            int s = time[0];
            int d = time[1];
            int c = time[2];
            adjacents.putIfAbsent(s, new ArrayList<>());
            adjacents.get(s).add(new Pair(c, d));
        }
        int[] isReceivedAt = new int[n + 1];
        Arrays.fill(isReceivedAt, Integer.MAX_VALUE);
        int ans = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.add(new Pair(0, k));
        isReceivedAt[k] = 0;
        while(!pq.isEmpty()){
            Pair<Integer, Integer> pair = pq.poll();
            int src = pair.getValue();
            if(!adjacents.containsKey(src)){
                continue;
            }
            int cost = pair.getKey();
            List<Pair<Integer, Integer>> list = adjacents.get(src);
            for(Pair<Integer, Integer> p : list){
                int d = p.getValue();
                int c = p.getKey();
                int cc = isReceivedAt[src] + c;
                if(isReceivedAt[d] > cc){
                    isReceivedAt[d] = cc;
                    pq.add(new Pair(isReceivedAt[d], d));
                }
            }
        }
        for(int i = 1; i <= n; i++){
            ans = Math.max(isReceivedAt[i], ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
