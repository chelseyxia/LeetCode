class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int cur = 0;
        int[] diff = new int[1000 + 1 + 1];
        for (int[] t : trips){
            int num = t[0], from = t[1], to = t[2];
            diff[from] += num;
            diff[to] -= num;
        }
        for(int i = 0; i <= 1000; i++){
            cur += diff[i];
            if(cur > capacity){
                return false;
            }
        }

        return true;
    }
}
