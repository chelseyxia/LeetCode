class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        return dynamic(amount, new int[amount], coins);
    }
    private int dynamic(int rem, int[] count, int[] coins){
        if(rem < 0){
            return -1;//no ans
        }
        if(rem == 0){
            return 0;
        }
        if(count[rem - 1] != 0){
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dynamic(rem - coin, count, coins);
            if(res >= 0 && res < min){
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
