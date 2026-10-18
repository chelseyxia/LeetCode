class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> perm = new ArrayList();
        for(int num : nums){
            perm.add(num);
        }
        backTracking(nums.length, perm, ans, 0);
        return ans;
    }
    
    public void backTracking(int n, List<Integer> perm, List<List<Integer>> ans, int first){
        if(first == n){
            ans.add(new ArrayList(perm));
            return;
        }
        for(int i = first; i < n; i++){
            Collections.swap(perm, first, i);
            backTracking(n, perm, ans, first + 1);
            Collections.swap(perm, first, i);            
        }

    }
}
