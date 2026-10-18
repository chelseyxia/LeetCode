class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack();
        stack.push(heights.length - 1);
        int maxHeight = heights[heights.length - 1];
        for(int i = heights.length - 2; i >= 0; --i){
            int h = heights[i];
            if(h > maxHeight){
                maxHeight = heights[i];
                stack.push(i);
            }
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            ++i;
        }
        return ans;
    }
}
