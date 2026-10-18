class Solution {

    public int maxArea(int[] height) {
        int area = 0;
        int low = 0; 
        int high = height.length - 1;
        while(low < high){
            int s = (high - low) * Math.min(height[low], height[high]);
            area = Math.max(area, s);
            if(height[low] < height[high]){
                low++; 
            }
            else{
                high--;
            }
        }
        return area;
    }
}
