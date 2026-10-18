class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(
            a[1], b[1]
        ));
        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()){
            int num = mapEntry.getKey();
            int fre = mapEntry.getValue();
            if(minHeap.size() < k){
                minHeap.offer(new int[]{num, fre});
            }
            else{
                int[] cur = minHeap.peek();
                int curNum = cur[0];
                int curFre = cur[1];
                if(curFre < fre){
                    minHeap.poll();
                    minHeap.offer(new int[]{num, fre});
                }
            }
        }
        for(int i = 0; i < k; i++){
            int[] cur = minHeap.poll();
            ans[i] = cur[0];
        }
        return ans;
    }
}
