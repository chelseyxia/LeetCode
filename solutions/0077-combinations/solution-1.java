class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> comb = new ArrayList();
        backTracking(k, n, ans, comb, 1);
        return ans;
    }
    //n == 4 -> arr = {0, 1, 2, 3}
    private void backTracking(int k, int n, List<List<Integer>> ans, List<Integer> comb, int first){
        if(comb.size() == k){
            ans.add(new ArrayList(comb));
            return;
        }
        for(int i = first; i < n + 1; i++){
            comb.add(i);
            backTracking(k, n, ans, comb, i + 1);
            comb.remove(comb.size() - 1);
        }
        
    }
}
