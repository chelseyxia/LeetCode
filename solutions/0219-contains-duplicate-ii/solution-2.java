class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            Integer v = map.put(nums[i], i);            
            if(v != null){
                if(i - v <= k){
                    return true;
                }
            }
            
        }
        return false;
    }
}
