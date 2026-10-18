class Solution {
    public int maxArea(int[] height) {
        //double points
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left < right){
            if(height[left] < height[right]){
                int temp = height[left];
                ans = Math.max(ans, temp * (right - left));
                while(left < right && height[left] <= temp){
                    left++;
                }
            }
            else{
                int temp = height[right];
                ans = Math.max(ans, temp * (right - left));
                while(left < right && height[right] <= temp){
                    right--;
                }                
            }
        }
        return ans;
    }
}
