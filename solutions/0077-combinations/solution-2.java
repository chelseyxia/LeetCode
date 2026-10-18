class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, 1, n, k, new ArrayList<>());
        return res;
    }
    public void backtrack(List<List<Integer>> res, int start, int n, int k, List<Integer> path){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++){
            path.add(i);
            backtrack(res, i + 1, n, k - 1, path);
            path.remove(path.size() - 1);
        }
    }
}
