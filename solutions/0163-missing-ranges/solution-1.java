class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0){
            range(lower, upper, ans);
            return ans;
        }
        int start = lower;
        for(int end : nums){
            if(start < end){
                range(start, end - 1, ans);
            }
            start = end + 1;
        }
        if(start <= upper){
            range(start, upper, ans);
        }
        return ans;
    }
    private void range(int lower, int upper, List<String> list){
        if(lower == upper){
            list.add(Integer.toString(lower));
            return;
        }
        list.add(Integer.toString(lower) + "->" + Integer.toString(upper));
    }
}
