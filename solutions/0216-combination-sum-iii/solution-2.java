class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, k, n, n, 1, new ArrayList<>());
        return res;
    }
    public void backtrack(List<List<Integer>> res, int k, int n, int remain, int start, List<Integer> path){
        if(k == 0 && remain == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= 9; i++){
            path.add(i);
            backtrack(res, k - 1, n, remain - i, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
