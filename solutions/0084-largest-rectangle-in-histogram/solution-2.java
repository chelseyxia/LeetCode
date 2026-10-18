class Solution {
    public int largestRectangleArea(int[] heights) {
        //max(minimum element * length of subarray)
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();
        int ans = 0;
        for(int i = 0; i < n; i++){
            while(!stackLeft.isEmpty() && heights[i] <= heights[stackLeft.peek()]){
                stackLeft.pop();
            }
            left[i] = stackLeft.isEmpty() ? -1 : stackLeft.peek();
            stackLeft.push(i);
        }
        for(int i = n-1; i >= 0; i--){
            while(!stackRight.isEmpty() && heights[i] < heights[stackRight.peek()]){
                stackRight.pop();
            }
            right[i] = stackRight.isEmpty() ? n : stackRight.peek();
            stackRight.push(i);
        }
        for(int i = 0; i < n; i++){
            int area = heights[i] * (right[i] - left[i] - 1);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
