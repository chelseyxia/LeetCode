class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] p = new long[n + 1];
        int ans = n + 1;
        for(int i = 0; i < n; i++){
            p[i + 1] = p[i] + (long)nums[i];
        }
        Deque<Integer> monoq = new LinkedList();
        for(int j = 0; j < p.length; j++){
            while(!monoq.isEmpty() && p[j] <= p[monoq.getLast()]){
                monoq.removeLast();
            }
            while(!monoq.isEmpty() && p[j] >= p[monoq.getFirst()] + k){
                ans = Math.min(ans, j - monoq.removeFirst());
            }
            
            
            monoq.addLast(j);
        }
        return ans < n + 1 ? ans : -1;
    }
}
