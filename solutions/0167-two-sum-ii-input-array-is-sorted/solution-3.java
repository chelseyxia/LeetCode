class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int n = numbers.length;
        int left = 0, right = n - 1;
        while(left < right){
            int numLeft = numbers[left];
            int numRight = numbers[right];
            if(numLeft + numRight > target){
                right--;
                continue;
            }
            else if(numLeft + numRight < target){
                left++;
                continue;
            }
            else{
                ans[0] = left+1;
                ans[1] = right+1;
                break;
            }
        }
        return ans;
    }
}
