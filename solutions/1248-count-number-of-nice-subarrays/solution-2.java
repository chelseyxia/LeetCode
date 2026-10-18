class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }
    public int atMostK(int[] A, int k){
        int res = 0, left = 0;
        for(int i = 0; i < A.length; i++){
            k -= A[i] % 2;
            while(k < 0){
                k += A[left++] % 2;
            }
            res += i - left + 1;
        }
        return res;
    }
}
