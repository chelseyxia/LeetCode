class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length - 1;
        int left1 = 0, right1 = n;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                long sum1 = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                long t = target - sum1;

                while(left < right){
                    if(left > j + 1 && nums[left] == nums[left - 1]){
                        left++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }   
                    long sum2 = nums[left] + nums[right];
                    if(sum2 == t){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                    else if(sum2 < t){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
