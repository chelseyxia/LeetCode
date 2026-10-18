class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int max_product = nums[0];
        int min_product = nums[0];
        int ans = max_product;
        for(int i = 1; i < n; i++){
            int cur = nums[i];
            int temp = Math.max(cur, Math.max(max_product * cur, min_product * cur));
            min_product = Math.min(cur, Math.min(max_product * cur, min_product * cur));
            max_product = temp;
            ans = Math.max(max_product, ans);
        }
        
        return ans;
    }
}
