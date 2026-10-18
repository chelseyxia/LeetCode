class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(res, nums, used, new ArrayList<>());
        return res;
    }
    public void backtrack(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(res, nums, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
