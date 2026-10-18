class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int res = 0;
        int left_boundary = height[0];
        int right_boundary = height[n - 1];
        int left = 0, right = n - 1;
        while(left < right){
            if(left_boundary < right_boundary){
                left += 1;
                left_boundary = Math.max(left_boundary, height[left]);
                res += Math.max(0, left_boundary - height[left]);
            }
            else{
                right -= 1;
                right_boundary = Math.max(right_boundary, height[right]);
                res += Math.max(0, right_boundary - height[right]);
            }
        }
        return res;
    }
}
