class Solution {
    
    int[][] memo = new int[1001][51];//edge
    
    private int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subArrayCount){
        int n = prefixSum.length - 1;
        if(memo[currIndex][subArrayCount] != -1){
            return memo[currIndex][subArrayCount];
        }
        
        if(subArrayCount == 1){
            return memo[currIndex][subArrayCount] = prefixSum[n] - prefixSum[currIndex];
        }
        
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for(int i = currIndex; i <= n - subArrayCount; i++){
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];
            int largestSplitSum = Math.max(firstSplitSum, getMinimumLargestSplitSum(prefixSum, i + 1, subArrayCount - 1));
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);
            
            if(firstSplitSum >= minimumLargestSplitSum){
                break;
            }
        }
        
        return memo[currIndex][subArrayCount] = minimumLargestSplitSum;
    }
    
    public int splitArray(int[] nums, int m) {
        //minimize the largest sum of subarrays
        //m is the subarray's number
        //n - 1 position can be chosed as split positions
        //need m - 1 position
        //top down dynamic programming: [0, i]: 1; [i + 1, n - 1]: m - 1
        //divide the problem into smaller problems
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        Arrays.fill(prefixSum, 0);
        
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        return getMinimumLargestSplitSum(prefixSum, 0, m);
    }
}
