class Solution {
    public int maxSumMinProduct(int[] nums) {
        // 固定 nums[i] 作为 minimum
            // → 找左边第一个更小元素
            // → 找右边第一个更小元素
        long ans = 0;
        int MOD = 1_000_000_007;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        long[] prefix = new long[n+1];
        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stackLeft.isEmpty() && nums[i] <= nums[stackLeft.peek()]){
                stackLeft.pop();
            }
            left[i] = stackLeft.isEmpty() ? -1 : stackLeft.peek();
            stackLeft.push(i);
        }
        for(int i = n-1; i >= 0; i--){
            while(!stackRight.isEmpty() && nums[i] < nums[stackRight.peek()]){
                stackRight.pop();
            }
            right[i] = stackRight.isEmpty() ? n : stackRight.peek();
            stackRight.push(i);
        }
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        for(int i = 0; i < n; i++){
            long rangeSum = prefix[right[i]] - prefix[left[i] + 1];
            long product = nums[i] * rangeSum;
            ans = Math.max(ans, product);
        }
        return (int)(ans%MOD);
    }
}
