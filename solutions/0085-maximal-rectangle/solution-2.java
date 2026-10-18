class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;
        int[] heights = new int[cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(matrix[r][c] == '1'){
                    heights[c]++;
                }
                else{
                    heights[c] = 0;
                }
            }
            int area = curArea(heights);
            ans = Math.max(ans, area);
        }
        return ans;
    }
    public int curArea(int[] heights){
        int n = heights.length;
        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        int area = 0;
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
            int curArea = heights[i] * (right[i] - left[i] - 1);
            area = Math.max(area, curArea);
        }
        return area;
    }
}
