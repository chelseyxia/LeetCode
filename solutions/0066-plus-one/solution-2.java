class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int lastDigitSum = digits[n - 1] + 1;
        int carry = lastDigitSum / 10;
        digits[n - 1] = lastDigitSum % 10;
        for(int i = digits.length - 2; i >= 0; i--){
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if(carry == 0){
            return digits;
        }
        int[] newArray = new int[n + 1];
        newArray[0] = carry;
        for(int i = 1; i < n + 1; i++){
            newArray[i] = digits[i - 1];
        }
        return newArray;
    }
}
