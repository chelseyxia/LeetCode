class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        char[] arr = colors.toCharArray();
        int n = colors.length();
        int[][] dp = new int[n][26];
        List<Integer>[] G = new ArrayList[n];
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            G[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
                dp[i][arr[i] - 97]++;
            }
        }
        
        int max = 1;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int w : G[v]){
                int num = Math.max(dp[v][arr[w] - 97] + 1, dp[w][arr[w] - 97]);
                max = Math.max(max, num);
                for(int i = 0; i < dp[v].length; i++){
                    dp[w][i] = Math.max(dp[v][i], dp[w][i]);
                }
                dp[w][arr[w] - 97] = num;
                if(--indegree[w] == 0){
                    queue.add(w);
                }
            }
        }
        
        for(int i : indegree){
            if(i != 0){
                return -1;
            }
        }
        
        return max;
    }
}
