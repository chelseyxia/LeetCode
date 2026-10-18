class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList();
        for(int i = 0; i < arr.length - 1; i++){
            int curr = arr[i + 1] - arr[i];
            if(curr < min){
                min = curr;
                ans.clear();
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            else if(curr == min){
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }
}
