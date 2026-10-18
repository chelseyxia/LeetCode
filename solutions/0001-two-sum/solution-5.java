class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int sub = target - nums[i];
            if(map.containsKey(sub)){
                ans[0] = i;
                if(map.get(sub) != i)
                ans[1] = map.get(sub);
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
