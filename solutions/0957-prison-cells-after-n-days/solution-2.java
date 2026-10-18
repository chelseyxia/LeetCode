class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
    //both neighbors occupied or vacant -> occupied
        //vacant
        int N = n % 14 == 0 ? 14 : n % 14;
        for(int i = 0; i < N; i++){
            int[] next = new int[cells.length];
            for(int j = 1; j < 7; j++){
                if(cells[j - 1] == cells[j + 1]){
                    next[j] = 1;
                }
                else{
                    next[j] = 0;
                }
            }
            cells = next;
        }
        return cells;
    }
}
