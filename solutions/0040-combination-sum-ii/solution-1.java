class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> comb = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(candidates);
        backTracking(candidates, target, comb, ans, 0, 0);
        return ans;
    }
    
    private void backTracking(int[] candidates, int target, List<Integer> comb, List<List<Integer>> ans, int sum, int first){
        if(sum == target){
            ans.add(new ArrayList(comb));
            return;
        }
        for(int i = first; i < candidates.length; i++){
            if(i > first && candidates[i] == candidates[i - 1]){
                continue;
            }
            int res = sum + candidates[i];
            if(res <= target){
                comb.add(candidates[i]);
                backTracking(candidates, target, comb, ans, res, i + 1);
                comb.remove(comb.size() - 1);  
            }
            else{
                break;
            }
        }
    }
}
