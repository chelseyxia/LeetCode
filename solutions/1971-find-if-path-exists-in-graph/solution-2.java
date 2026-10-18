class UnionPath{
    //define an array
    int[] root;
    //constructor
    public UnionPath(int size){
        root  = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
        }
    }
    //method find
    public int find(int x){
        while(x != root[x]){
            x = root[x];
        }
        return x;
    }
    //method union
    public void union(int x, int y){
        int findX = find(x);
        int findY = find(y);
        if(findX != findY){
            root[findY] = findX;
        }
    }
    //boolean isConnected
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //union path
        UnionPath unionPath = new UnionPath(n);
        for(int i = 0; i < edges.length; i++){
            unionPath.union(edges[i][0], edges[i][1]);
        }
        return unionPath.isConnected(source, destination);
    }
}
