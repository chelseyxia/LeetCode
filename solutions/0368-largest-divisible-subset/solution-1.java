class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0){
            return new ArrayList();
        }
        List<ArrayList> EDS = new ArrayList();
        for(int num : nums){
            EDS.add(new ArrayList());
        }
        for(int i = 0; i < n; i++){
            List<Integer> maxSubset = new ArrayList();
            for(int k = 0; k < i; k++){
                if(nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size()){
                    maxSubset = EDS.get(k);
                }
            }
            EDS.get(i).addAll(maxSubset);
            EDS.get(i).add(nums[i]);
        }

        List<Integer> ans = new ArrayList();
        for(int i = 0; i < n; i++){
            if(ans.size() < EDS.get(i).size())
                ans = EDS.get(i);
        }
        return ans;
    }
}
