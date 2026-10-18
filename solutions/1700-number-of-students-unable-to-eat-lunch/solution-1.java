class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for(int num : students){
            counts[num] += 1;
        }
        int n = sandwiches.length;
        for(int i = 0; i < n; i++){
            if(counts[sandwiches[i]] > 0){
                counts[sandwiches[i]] -= 1;
            }
            else{
                return n - i;
            }
        }
        return 0;
    }
}
