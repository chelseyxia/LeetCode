class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        for(int i = 0; i < n+1; i++){
            while(!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]){
                deque.pollLast();
            }
            while(!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k){
                ans = Math.min(ans, i-deque.peekFirst());
                deque.pollFirst();
            }
            deque.offerLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
