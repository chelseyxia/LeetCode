class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(List<List<Integer>> res, int[] nums, int start, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            backtrack(res, nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
