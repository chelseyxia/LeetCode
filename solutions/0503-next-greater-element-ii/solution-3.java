class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i = 0; i < n * 2; i++){
            int curIndex = i % n;
            while(!stack.isEmpty() && nums[curIndex] > nums[stack.peek()]){
                int index = stack.pop();
                ans[index] = nums[curIndex];
            }
            if(i < n){
                stack.push(curIndex);
            }
        }
        return ans;
    }
}
