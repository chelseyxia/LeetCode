class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int key : map.keySet()){
            maxHeap.add(key);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        for(int i = 0; i < k; i++){
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}
