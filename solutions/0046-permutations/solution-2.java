class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        helper(nums, 0, ans);
        return ans;
    }
    private void helper(int[] nums, int index, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> temp = new ArrayList();
            for(int num : nums){
                temp.add(num);
            }
            ans.add(temp);
        }
        for(int i = index; i < nums.length; i++){
            swap(i, index, nums);
            helper(nums, index + 1, ans);
            swap(i, index, nums);
        }
    }
    private void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
