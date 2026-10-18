class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;
        queue.add(amount);
        Arrays.sort(coins);
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int q = queue.poll();
                for(int coin : coins){
                    int next = q - coin;
                    if(next == 0){
                        return step;
                    }
                    if(next < 0){
                        break;
                    }
                    if(!visited[next]){
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
