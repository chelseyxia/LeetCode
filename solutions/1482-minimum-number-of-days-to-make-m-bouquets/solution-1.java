class Solution {
    /*
        Search space:
        在“天数”这个答案空间里搜索，而不是搜索数组 index。
        left = min(bloomDay)
        right = max(bloomDay)
        check(day):
        到第 day 天时，是否能用连续的 k 朵花做出至少 m 束花。
    */
    /*
    Pattern:
        Binary Search on Answer
        State:
        [left, right] represents the current possible range of minimum days.
        Invariant:
        The minimum feasible day is always inside [left, right].
        check(mid):
        Whether we can make at least m bouquets by day mid.
    */
    public int minDays(int[] bloomDay, int m, int k) {
        int days = 0;
        for(int b : bloomDay){
            days = Math.max(days, b);
        }
        int left = 0, right = days;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canMake(mid, bloomDay, m, k)){
                right = mid;
            } 
            else{
                left = mid+1;
            }
        }
        if((long)m * k > bloomDay.length){
            return -1;
        }
        return right;
    }
    /*
    invariant:
    After processing bloomDay[0...i]:
    consecutive =
    number of consecutive bloomed flowers at the end of current segment
    that have not been used in a bouquet yet.
    m =
    remaining bouquets needed.
    */
    public boolean canMake(int day, int[] bloomDay, int m, int k){
        int consecutive = 0;
        for(int i = 0; i < bloomDay.length; i++){
            int b = bloomDay[i];
            if(b <= day){
                consecutive++;
            }
            else{
                consecutive = 0;
            }
            if(consecutive == k){
                m--;
                consecutive = 0;
            }
        }
        return m <= 0;
    }
}
