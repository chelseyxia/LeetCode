class Solution {
    public int[] plusOne(int[] digits) {
        int k = 1;
        int n = digits.length;
        for(int i = n-1; i >= 0 ; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }
            else{
                digits[i]++;
                return digits;
            }
        }
        int[] s = new int[n + 1];
        s[0] = 1;
        return s;
        

        
    }
}
