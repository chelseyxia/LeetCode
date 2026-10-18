class Solution {
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for(int i = 0; i < mat[0].length; i++){
            pq.add(mat[0][i]);
        }
        for(int i = 1; i < n; i++){
            PriorityQueue<Integer> pqTemp = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
            for(int j = 0; j < mat[0].length; j++){
                int curr = mat[i][j];

                if(pq.contains(curr)){
                    pqTemp.add(curr);
                }
            }
            pq = pqTemp;
        }
        if(!pq.isEmpty()){
            return pq.peek();    
        }
        else{
            return -1;
        }
    }
}

//1 2 3 4 5
//2 4 5 8 10
//3 5 7 9 11
//1 3 5 7 9
