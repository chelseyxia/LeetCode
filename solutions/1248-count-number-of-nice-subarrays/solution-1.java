class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //2221221222
        //(3 + 1) * (3 + 1)
        int n = nums.length;
        int left = 0;
        int right = 0;
        int oddcnt = 0;
        int res = 0;
        while(right < n){
            if((nums[right++] & 1) == 1){
                oddcnt++;
            }
            if(oddcnt == k){
                int temp = right;
                while(right < nums.length && (nums[right] & 1) == 0){
                    right++;
                }
                int rightEventCnt = right - temp;
                int leftEventCnt = 0;
                while((nums[left] & 1) == 0){
                    leftEventCnt++;
                    left++;
                }
                res += (leftEventCnt + 1) * (rightEventCnt + 1);
                left++;
                oddcnt--;
            }
        }
              
        return res;
    }
}
//2221221
//22212212
//222122122
//2221221222
// + 4
//+4
//+4
//1221: must be contained
//front: 222   back: 222
//3 * 2 * 1 * 2 = 12
