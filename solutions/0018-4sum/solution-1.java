class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return  kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        List<List<Integer>> ans = new ArrayList<>();
        if(start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k){
            return ans;
        }
        if(k == 2){
            return twoSum(nums, target, start);
        }
        for(int i = start; i < nums.length; ++i){
            if(i == start || nums[i - 1] != nums[i]){
                for(List<Integer> subSet : kSum(nums, target - nums[i], i + 1, k - 1)){
                    ans.add(new ArrayList<> (Arrays.asList(nums[i])));
                    ans.get(ans.size() - 1).addAll(subSet);
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<>();
        int low = start;
        int high = nums.length - 1;

        while(low < high){
            int curSum = nums[low] + nums[high];
            if(curSum < target || (low > start && nums[low] == nums[low - 1])){
                ++low;
            }
            else if(curSum > target ||(high < nums.length - 1 && nums[high] == nums[high+1])){
                --high;
            }
            else{
                res.add(Arrays.asList(nums[low++], nums[high--]));
            }
        }        
        return res;
    }
}
