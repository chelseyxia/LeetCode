class unionFind{
    int[] root;
    public unionFind(int size){
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
        }
    }
    public int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return false;
        }
        root[rootY] = rootX;
        return true;
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>(){
            @Override
            public int compare(int[] log1, int[] log2){
                Integer tsp1 = new Integer(log1[0]);
                Integer tsp2 = new Integer(log2[0]);
                return tsp1.compareTo(tsp2);
            }
        });
        unionFind unionfind = new unionFind(n);
        int groupCnt = n;
        for(int[] log : logs){
            int timestamp = log[0];
            int x = log[1];
            int y = log[2];
           // unionfind.union(x, y);
            if(unionfind.union(x, y)){
                groupCnt -= 1;
            }
            
            int temp = unionfind.root[0];
            if(groupCnt == 1){
                return timestamp;
            }
            
        }
        return -1;
    }
}
