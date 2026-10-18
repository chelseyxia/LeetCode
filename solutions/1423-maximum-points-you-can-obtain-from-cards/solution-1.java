class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //we can find the min subarray, then total subarray - min subarray, so that we can get the answer;
        int n = cardPoints.length;
        int left = 0;
        int minsubarraysum = Integer.MAX_VALUE;
        int totalsum = 0;
        int presentsum = 0;
        
        for(int i = 0; i < n; i++){
            totalsum += cardPoints[i];
        }
        
        if(k == n){
            return totalsum;
        }
        
        for(int i = 0; i < n; i++){
            presentsum += cardPoints[i];
            int presentsubarraylength = i - left + 1;
            if(presentsubarraylength == n - k){
                minsubarraysum = Math.min(minsubarraysum, presentsum);
                presentsum -= cardPoints[left++];
            }
        }
        return totalsum - minsubarraysum;
    }
}
