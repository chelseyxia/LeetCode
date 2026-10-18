import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //distinct integers
        //number can be chosed multiple times
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList();
        backTracking(candidates, target, ans, temp, 0);
        return ans;
    }
    
    private void backTracking(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int index){
        //base case
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        backTracking(candidates, target, ans, temp, index + 1);
        if(target - candidates[index] >= 0){
            temp.add(candidates[index]);
            backTracking(candidates, target - candidates[index], ans, temp, index);
            temp.remove(temp.size() - 1);
        }
        //else
    }
}
