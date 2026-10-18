class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /* Monotonic Deque（double ended queue）
            Deque 中的 index 永远是递增的。
            Front 是最早进入窗口的元素。
            窗口向右滑时，
            只有 Front 才可能过期。
        */
        //另外返回数组长度应该是：n - k + 1
        // question 1: 队列里应该存 value 还是 index？
            // index - 原因是我们需要判断队头元素有没有滑出窗口：deque.peekFirst() < right - k + 1
        //question 2: boundary: right - left + 1 = k 
            // - > left = right - k + 1
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int left = 0;
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && deque.peekFirst() < left){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i - left >= k - 1){
                ans[left] = deque.isEmpty() ? nums[i] : nums[deque.peekFirst()];
                left++;
            }
        }

        return ans;
    }
}
