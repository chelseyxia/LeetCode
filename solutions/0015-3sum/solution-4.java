class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList();
        
        if(n < 3 || nums[0] > 0){
            return ans;
        }
        for(int i = 0; i < n - 2; i++){
            int temp = -nums[i];
            int left = i + 1;
            int right = n - 1;
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            while(left < right){
                if((left < right) && (nums[left] + nums[right]) > temp){
                    right--;
                }
                if((left < right) && (nums[left] + nums[right]) < temp){
                    left++;
                }  
                if((left < right) && (nums[left] + nums[right]) == temp){
                    List<Integer> t = new ArrayList();
                    t.add(-temp);
                    t.add(nums[left]);
                    t.add(nums[right]);
                    ans.add(t);
                    right--;
                    left++;
                    while((left < right) && (nums[left] == nums[left - 1])){
                        left++;
                    }
                    while((left < right) && (nums[right] == nums[right + 1])){
                        right--;
                    }
                }
            }
        }  
        return ans;
    }
}
