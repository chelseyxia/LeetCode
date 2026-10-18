class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        while(i < arr.length && arr[i++] <= k){
            k++;
        }
        return k;
    }
}
