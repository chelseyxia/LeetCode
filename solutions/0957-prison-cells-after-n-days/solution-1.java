class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int N = (n - 1) % 14 + 1;
        for(int i = 0; i < N; i++){
            cells = newcell(cells);
        }
        return cells;
    }
    public int[] newcell(int[] cells){
        int[] array = new int[cells.length];
        for(int i = 1; i < cells.length - 1; i++){
            if(cells[i - 1] == cells[i + 1]){
                array[i] = 1;
            }
            else{
                array[i] = 0;
            }
        }
        return array;
    }
}
