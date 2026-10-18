class Solution {
    public int minStartValue(int[] nums) {
        int minvalue = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            minvalue = Math.min(minvalue, sum);
        }
        return -minvalue + 1;
    }
}
