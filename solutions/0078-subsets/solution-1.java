class Solution {
    int i;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> comb = new ArrayList();
        int n = nums.length;
        for(i = 0; i < n + 1; i++){
            backTracking(nums, comb, ans, 0);            
        }
        return ans;
    }
    
    public void backTracking(int[] nums, List<Integer> comb, List<List<Integer>> ans, int first){
        if(comb.size() == i){
            ans.add(new ArrayList(comb));
            return;
        }
        for(int j = first; j < nums.length; j++){
            comb.add(nums[j]);
            backTracking(nums, comb, ans, j + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
