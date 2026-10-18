class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        int left = 0, right = 1;
        int n = points.length;
        Deque<Integer> dq = new ArrayDeque();
        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty() && points[i][0] - points[dq.peekFirst()][0] > k){
                dq.pollFirst();
            }
            if(!dq.isEmpty()){
                int[] top = points[dq.peekFirst()];
                int[] curr = points[i];
                int equaVal = top[1] + curr[1] + Math.abs(top[0] - curr[0]);
                max = Math.max(max, equaVal);
            }
            while(!dq.isEmpty() && (points[dq.peekLast()][1] - points[dq.peekLast()][0]) <= (points[i][1] - points[i][0])){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return max;
    }
}
