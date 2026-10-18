class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //Arrays.sort(nums);
        int n = nums.length;
        List<Integer> perm = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        
        for(int num : nums){
            perm.add(num);
        }
        backTracking(n, perm, ans, 0);
        return ans;
    }
    
    public void backTracking(int n, List<Integer> perm, List<List<Integer>> ans, int first){
        if(first == n && !ans.contains(perm)){
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
