class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 1) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
       pq.addAll(map.entrySet());
        for(int i = 0; i < k && !pq.isEmpty(); ++i){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
