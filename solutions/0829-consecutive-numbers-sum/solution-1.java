class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int upper_limit = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        for(int k = 1; k <= upper_limit; ++k){
            n -= k;
            if(n % k == 0){
                count++;
            }
        }
        return count;
    }
}

//5 = 2 + 3
//9 = 4 + 5 = 2 + 3 + 4
//15 = 7 + 8 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
