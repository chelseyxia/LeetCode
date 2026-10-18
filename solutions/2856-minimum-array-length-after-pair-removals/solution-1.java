class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        if(n == 1){
            return n;
        }
        int frequency = 1;
        int maxFrequency = 1;
        for(int i = 1; i < n; i++){
            if(nums.get(i).equals(nums.get(i-1))){
                frequency++;
            }
            else{
                maxFrequency = Math.max(maxFrequency, frequency);
                frequency = 1;
            }
        }
        maxFrequency = Math.max(maxFrequency, frequency);
        if(maxFrequency > n - maxFrequency){
            return maxFrequency * 2 - n;
        }
        else{
            return Math.max(maxFrequency * 2 - n, n % 2);
        }
    }
}
