class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int numsLen = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(numsLen < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < numsLen; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1, k = numsLen - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if( sum == 0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[k]);
                    ans.add(cur);
                    while(j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k - 1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }
}
