class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxWater = 0;
        while(left < right){
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, curArea);
            if(height[left] <= height[right]){
                left++;
                continue;
            }
            else if(height[right] < height[left]){
                right--;
                continue;
            }
        }
        return maxWater;
    }
}
