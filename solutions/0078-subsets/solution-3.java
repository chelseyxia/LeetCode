// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         backtrack(nums, res, 0, new ArrayList<>());
//         return res;
//     }
//     public void backtrack(int[] nums, List<List<Integer>> list, int index, List<Integer> path){
//         list.add(new ArrayList<>(path));
//         for(int i = index; i < nums.length; i++){
//             path.add(nums[i]);
//             backtrack(nums, list, i + 1, path);
//             path.remove(path.size() - 1);
//         }
//     }
// }

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> list, int index, List<Integer> path){
        if(index == nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, list, index + 1, path);

        path.add(nums[index]);
        dfs(nums, list, index + 1, path);
        path.remove(path.size() - 1);
    }
}
