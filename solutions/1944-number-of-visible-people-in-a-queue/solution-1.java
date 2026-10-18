class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--){
            int hei = heights[i];
            while(!stack.isEmpty() && hei > heights[stack.peek()]){
                stack.pop();
                ans[i] += 1;
            }
            if(!stack.isEmpty() && hei < heights[stack.peek()]){
                ans[i] += 1;
            }
            stack.push(i);
        }
        return ans;
    }
}
