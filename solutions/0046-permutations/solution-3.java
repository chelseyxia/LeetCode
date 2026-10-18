class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //backtrcking
        backtracking(nums, 0, list);            
        return list;
    }
    private void backtracking(int[] nums, int i, List<List<Integer>> ans){
        if(i == nums.length - 1){
            List<Integer> temp = new ArrayList<>();
            for(int k = 0; k < nums.length; k++){
                temp.add(nums[k]);
            }
            ans.add(new ArrayList<>(temp));
        }
        for(int j = i; j < nums.length; j++){
            swap(i, j, nums);
            backtracking(nums, i + 1, ans);
            swap(j, i, nums);
        }
    }
    private void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
