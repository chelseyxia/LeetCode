class Solution {
    int i;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        List<Integer> comb = new ArrayList();
        for(i = 0; i < nums.length + 1; i++){
            backTracking(nums, ans, comb, 0);
        }
        return ans;
    }
    
    public void backTracking(int[] nums, List<List<Integer>> ans, List<Integer> comb, int first){
        if(comb.size() == i && !ans.contains(comb)){
            ans.add(new ArrayList(comb));
            return;     
        }
        for(int j = first; j < nums.length; j++){
            comb.add(nums[j]);
            backTracking(nums, ans, comb, j + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
