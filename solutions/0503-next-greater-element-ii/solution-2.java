class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < n * 2; i++){
            if(i < n){
                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    int index = stack.pop();
                    map.put(index, nums[i]);
                }
                stack.push(i);
            }
            else if(i < n * 2 && i >= n){
                while(!stack.isEmpty() && nums[i-n] > nums[stack.peek()]){
                    int index = stack.pop();
                    if(map.get(index) == null){
                        map.put(index, nums[i-n]);
                    }
                }
                stack.push(i-n);
            }
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = map.getOrDefault(i, -1);
        }
        return ans;
    }
}
