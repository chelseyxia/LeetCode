class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }
        int res = 0;
        int[] points = new int[max+1];
        for(int i = 0; i < n; i++){
            points[nums[i]] += nums[i];
        }
        int earn1 = 0;
        int earn2 = 0;
        for(int i = 0; i < max+1; i++){
            int tmp = earn2;
            earn2 = Math.max(earn2, points[i] + earn1);
            earn1 = tmp;
        }
        return earn2;
    }
}
