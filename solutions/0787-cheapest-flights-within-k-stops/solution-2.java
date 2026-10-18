class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        long[][] distances = new long[2][n];
        Arrays.fill(distances[0], Integer.MAX_VALUE);
        Arrays.fill(distances[1], Integer.MAX_VALUE);
        distances[0][src] = 0;
        distances[1][src] = 0;
        for(int i = 0; i < k + 1; i++){
            for(int[] flight : flights){
                int s = flight[0];
                int d = flight[1];
                int c = flight[2];
                long dU = distances[1 - i&1][s];
                long dV = distances[i&1][d];
                if(dU + c < dV){
                    distances[i&1][d] = dU + c;
                }
            }

        }
        return distances[k&1][dst] < Integer.MAX_VALUE ? (int)distances[k&1][dst] : -1;
    }
}
