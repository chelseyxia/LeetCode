class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> comb = new ArrayList();
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++){
            arr[i] = i + 1;
        }
        backTracking(n, k, arr, comb, ans, 0, 0);
        return ans;
    }
    
    private void backTracking(int target, int k, int[] arr, List<Integer> comb, List<List<Integer>> ans, int sum, int first){
        if(sum == target && comb.size() == k){
            ans.add(new ArrayList(comb));
            return;
        }
        for(int i = first; i < arr.length; i++){
            if(i > first && arr[i] == arr[i - 1]){
                continue;
            }
            int res = arr[i] + sum;
            if(res <= target){
                comb.add(arr[i]);
                backTracking(target, k, arr, comb, ans, res, i + 1);
                comb.remove(comb.size() - 1);  
            }
            else{
                break;
            }
        }
        
    }
}
