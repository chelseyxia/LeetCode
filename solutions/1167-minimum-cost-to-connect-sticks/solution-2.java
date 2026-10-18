class Solution {
    public int connectSticks(int[] sticks) {
        int sum = 0;
        if(sticks.length == 1 || sticks.length == 0){
            return 0;
        }
        //Arrays.sort(sticks);
        
        int s = 0;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        for(int i = sticks.length - 1; i >= 0 ; i--){
            que.add(sticks[i]);
        }
        while(que.size() > 1){
            int s1 = que.remove();
            int s2 = que.remove();
            sum += s1 + s2;
            que.add(s1 + s2);
        }       
        return sum;
    }
}
