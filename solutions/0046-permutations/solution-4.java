class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, used, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> path){
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, res, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
