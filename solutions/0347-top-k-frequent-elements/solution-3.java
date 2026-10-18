class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 1) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int n : map.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        for(int i = k - 1; i >= 0; i--){
            ans[i] = heap.poll();
        }
        return ans;
    }
}
