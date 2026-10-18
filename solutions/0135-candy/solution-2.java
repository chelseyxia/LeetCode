class Solution {
    public int candy(int[] ratings) {
        //two for loop
        int res = 0;
        int n = ratings.length;
        int[] c = new int[n];
        for(int i = 0; i < n; i++) c[i] = 1;
        for(int i = 1; i < n; i ++){
            if(ratings[i - 1] < ratings[i]){
                c[i] = c[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                c[i] = Math.max(c[i], c[i + 1] + 1);
            }
        }
        for(int candy : c){
            res += candy;
        }
        return res;
    }
                //斜率法 slot, time: O(n); space: O(1)
    //     int n = ratings.length;
    //     if(n == 0){
    //         return 0;
    //     }
    //     int up = 0, down = 0, res = 1, peak = 0;

    //     for(int i = 1; i < n; i++){
    //         if(ratings[i] > ratings[i-1]){
    //             up++;
    //             peak = up;
    //             down = 0;
    //             res += 1 + up;
    //         }
    //         else if(ratings[i-1] == ratings[i]){
    //             up = down = peak = 0;
    //             res += 1;
    //         }
    //         else{
    //             up = 0; 
    //             down++;
    //             res += down;
    //             if(down > peak) res++;
    //         }
    //     }
    //     return res;
    // }
}
