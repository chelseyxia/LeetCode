class Solution {
    int[] memo = new int[50001];
    
    private int findNextJob(int[] startTime, int lastEndTime){
        int start = 0;
        int end = startTime.length - 1;
        int nextIndex = startTime.length;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if(startTime[mid] >= lastEndTime){
                nextIndex = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return nextIndex;
    }
    
    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime){
        int length = startTime.length;
        for(int position = length - 1; position >= 0; position--){
            int curProfit = 0;
            int nextIndex = findNextJob(startTime, jobs.get(position).get(1));
            if(nextIndex != length){
                curProfit = jobs.get(position).get(2) + memo[nextIndex];
            }
            else{
                curProfit = jobs.get(position).get(2);
            }
            if(position == length - 1){
                memo[position] = curProfit;
            }
            else{
                memo[position] = Math.max(curProfit, memo[position + 1]);
            }
        }
        return memo[0];
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        int length = profit.length;
        for(int i = 0; i < length; i++){
            ArrayList<Integer> curJob = new ArrayList<>();
            curJob.add(startTime[i]);
            curJob.add(endTime[i]);
            curJob.add(profit[i]);
            jobs.add(curJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));
        for(int i = 0; i < length; i++){
            startTime[i] = jobs.get(i).get(0);
        }
        return findMaxProfit(jobs, startTime);
    }
}
