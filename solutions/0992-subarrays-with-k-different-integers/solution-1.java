class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int[] nums, int k){
        int left = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.getOrDefault(nums[i], 0) == 0){
                k--;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(k < 0){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    k++;
                }
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}
