class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int currPassengers = 0;
        //if total passengers > capacity return false
        //question to the interviewer: can we sort the array?
        //if currPassengers > capacity -> return false
        //how to sort trips with [j] in trips[i][j][k]?
        List<int[]> events = new ArrayList<>();
        for (int[] t : trips){
            events.add(new int[]{t[1], t[0]});
            events.add(new int[]{t[2], -t[0]});
        }
        events.sort((a,b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1])
                         : Integer.compare(a[0], b[0])
        );
        int cur = 0;
        for(int[] e : events){
            cur += e[1];
            if(cur > capacity){
                return false;
            }
        }
        return true;
    }
}
