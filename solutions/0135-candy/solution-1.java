class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 0){
            return 0;
        }
        int up = 0, down = 0, res = 1, peak = 0;

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                up++;
                peak = up;
                down = 0;
                res += 1 + up;
            }
            else if(ratings[i-1] == ratings[i]){
                up = down = peak = 0;
                res += 1;
            }
            else{
                up = 0; 
                down++;
                res += down;
                if(down > peak){
                    res++;
                }
            }

        }
        return res;
    }
}
