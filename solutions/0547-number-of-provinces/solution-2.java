class unionFind{
    int[] root;
    public unionFind(int size){
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = -1;
        }
    }
    public int find(int x){
        if(root[x] == -1){
            return x;
        }
        return find(root[x]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            root[rootX] = rootY;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        //the number of province
        //1 -> 1, 2
        //2 -> 1, 2
        //3 ->
        int n = isConnected.length;
        int cnt = 0;
        unionFind unionfind = new unionFind(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int temp = isConnected[i][j];
                if(temp == 1 && i != j){
                    unionfind.union(i, j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(unionfind.root[i] == -1){
                cnt++;
            }
        }
        return cnt;
    }
}
