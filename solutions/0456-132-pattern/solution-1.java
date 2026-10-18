class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int second = Integer.MIN_VALUE;;
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                second = nums[stack.pop()];
            }
            if(!stack.isEmpty() && nums[i] < second){
                return true;
            }
            stack.push(i);
        }
        return false;
    }
}
