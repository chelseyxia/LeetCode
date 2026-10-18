class Solution {
    private int K;
    public int[][] highFive(int[][] items) {
        this.K = 5;
        TreeMap<Integer, Queue<Integer>> allScore = new TreeMap<>();
        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            if(!allScore.containsKey(id)){
                allScore.put(id, new PriorityQueue<>((a, b) -> b - a));
            }
            allScore.get(id).add(score);
        }
        List<int[]> solution = new ArrayList<>();
        for(int id : allScore.keySet()){
            int sum = 0;
            for(int i = 0; i < this.K; i++){
                sum += allScore.get(id).poll();
            }
            solution.add(new int[] {id, sum / this.K});
        }
        int[][] ans = new int[solution.size()][];
        return solution.toArray(ans);
    }
}
