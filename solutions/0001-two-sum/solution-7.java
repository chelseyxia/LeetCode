class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            if(map.containsKey(key)){
                int index = map.get(key);
                if(index != i){
                    ans[0] = i;
                    ans[1] = index;
                    break;
                }
            }
            else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
