class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int k = n % 14 == 0 ? 14 : n % 14;
        for(int j = 0; j < k; j++){
            int[] newCells = new int[cells.length];
            for(int i = 1; i < cells.length - 1; i++){
                if(cells[i - 1] == cells[i + 1]){
                    newCells[i] = 1;
                }
                else if(cells[i - 1] != cells[i + 1]){
                    newCells[i] = 0;
                }
            }
            cells = newCells;
        }
        return cells;
    }
}
