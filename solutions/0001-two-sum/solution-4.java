class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        int[] ans = new int[2];
        for(int j = 0; j < nums.length; j++){
            int a = target -  nums[j];
            if(map.containsKey(a) && map.get(a) != j){
                ans[0] = j;
                ans[1] = map.get(a);
            }
        }
        return ans;
    }
}
