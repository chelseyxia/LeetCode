class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList();
        backTracking(candidates, target, temp, ans, 0);
        return ans;
    }
    
    private void backTracking(int[] cand, int target, List<Integer> temp, List<List<Integer>> ans, int idx){
        if(idx == cand.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        backTracking(cand, target, temp, ans, idx + 1);
        if(target - cand[idx] >= 0){
            temp.add(cand[idx]);
            backTracking(cand, target - cand[idx], temp, ans, idx);
            temp.remove(temp.size() - 1);
        }
    }
}
