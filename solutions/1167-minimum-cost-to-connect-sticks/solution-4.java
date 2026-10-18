class Solution {
    public int connectSticks(int[] sticks) {
        int sum = 0;
        if(sticks.length == 1 || sticks.length == 0){
            return 0;
        }
        int s = 0;
        //通过优先队列定义的api按从小到大取出元素，比如remove方法
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        for(int stick : sticks){
            que.add(stick);
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
