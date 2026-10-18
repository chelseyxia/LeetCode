class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> temp = new ArrayList();
        backTracking(candidates, target, 0, ans, temp);
        return ans;
    }
    private void backTracking(int[] cand, int t, int index, List<List<Integer>> ans, List<Integer> temp){
        if(index == cand.length){
            return;
        }
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        backTracking(cand, t, index + 1, ans, temp);
        if(t - cand[index] >= 0){
            temp.add(cand[index]);
            backTracking(cand, t - cand[index], index, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
