class Solution {
    public int[] searchRange(int[] nums, int target) {
        //hashmap store the index and value,
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] ans = new int[]{-1, -1};
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (high + low) / 2;
            if(nums[mid] == target){
                int m = mid;
                while(low <= m && nums[m] == target){
                    ans[0] = m--;
                }
                int n = mid;
                while(n <= high && nums[n] ==target){
                    ans[1] = n++;
                }
                return ans;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;;
            }

        }
        return ans;
    }
}
