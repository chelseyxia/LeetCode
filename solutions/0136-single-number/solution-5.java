class Solution {
    public int singleNumber(int[] nums) {
        // a xor a = 0; a xor 0 = a; a xor a xor b = b
        int a = 0;
        for(int num : nums){
            a ^= num;
        }
        return a;
    }
}
