class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left_boundary = new int[n];
        int[] right_boundary = new int[n];
        left_boundary[0] = height[0];
        right_boundary[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++){
            left_boundary[i] = Math.max(height[i], left_boundary[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            right_boundary[i] = Math.max(height[i], right_boundary[i + 1]);
        }
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            ans += Math.max(0, Math.min(left_boundary[i], right_boundary[i]) - height[i]);
        }
        return ans;
    }
}
