class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0; 
        int right = n - 1;
        int ans = 0;
        //greedy algorithm
        while(left < right){
            if(height[left] < height[right]){
                int temp = height[left];
                ans = Math.max(ans, temp * (right - left));
                while(left < right && temp >= height[left]){
                    left++;
                }
            }
            else{
                int temp = height[right];
                ans = Math.max(ans, temp * (right - left));
                while(left < right && temp >= height[right]){
                    right--;
                }                
            }
        }
        return ans;
    }
}
