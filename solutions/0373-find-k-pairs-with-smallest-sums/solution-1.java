class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(
            nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]
        ));
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            minHeap.offer(new int[]{i, 0});
        }
        List<List<Integer>> ans = new LinkedList<>();
        while(k != 0 && !minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            ans.add(List.of(nums1[cur[0]], nums2[cur[1]]));
            if(cur[1] + 1 < nums2.length){
                minHeap.offer(new int[]{cur[0], cur[1]+1});
            }
            k--;
        }
        return ans;
    }
}
