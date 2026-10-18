class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), 0, res);
        return res;
    }
    public void backtrack(int[] candidates, int remain, List<Integer> path, int index, List<List<Integer>> res){
        if(remain == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(remain < 0){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(remain > 0){
                path.add(candidates[i]);
            }
            backtrack(candidates, remain - candidates[i], path, i, res);
            path.remove(path.size() - 1);
        }
    }
}
