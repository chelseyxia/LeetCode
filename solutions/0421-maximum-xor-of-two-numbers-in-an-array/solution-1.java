class Solution {
    public int findMaximumXOR(int[] nums) {
     //XOR relation
        //bitwise
        //convert all integer to binary number
        //0 XOR x = x;
        //x XOR x = 0;
        // 3          10     5         25       2          8
        //00011     01010  00101     011001   00010      01000
        int maxNum = nums[0];
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
        }
        
        int maxXOR = 0;
        int currXOR = 0;
        
        Set<Integer> prefixes = new HashSet();
        int L = (Integer.toBinaryString(maxNum)).length();
        
        for(int i = L - 1; i > -1; --i){
            maxXOR <<= 1;
            currXOR = maxXOR | 1;
            prefixes.clear();
            for(int num : nums){
                prefixes.add(num >> i);
            }
            
            for(int p : prefixes){
                if(prefixes.contains(currXOR ^ p)){
                    maxXOR = currXOR;
                    break;
                }
            }
        }
        
        return maxXOR;
    }
}
