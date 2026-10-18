class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mark = l;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int numsToEnd = n - 1 - mid;
            if(mid == n - 1 || (nums[mid] != nums[mid + 1] && numsToEnd % 2 == 0)){
                mark = nums[mid];
                r = mid - 1;
            }
            else if(nums[mid] == nums[mid + 1] && numsToEnd % 2 == 1){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return mark;
    }
}
