class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] memo = new int[n1 + 1][n2 + 1];
        for(int i = n1 - 1; i >= 0; --i){
            for(int j = n2 - 1; j >= 0; --j){
                if(nums1[i] == nums2[j]){
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if(ans < memo[i][j]){
                        ans = memo[i][j];
                    }
                }
            }
        }     
        return ans;
    }
}
