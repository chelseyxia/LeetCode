class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubArraysMaxs(nums) - sumSubArraysMins(nums);
    }
    private long sumSubArraysMins(int[] parcels){
        long res = 0;
        int n = parcels.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || parcels[stack.peek()] > parcels[i])){
                int mid = stack.pop();
                int l = mid - (stack.isEmpty() ? -1 : stack.peek());
                int r = i - mid;
                res += (long)parcels[mid] * (l) * (r);
            }
            stack.push(i);
        }
        return res;
    }
    private long sumSubArraysMaxs(int[] parcels){
        long res = 0;
        int n = parcels.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || parcels[stack.peek()] < parcels[i])){
                int mid = stack.pop();
                int l = mid - (stack.isEmpty() ? -1 : stack.peek());
                int r = i - mid;
                res += (long)parcels[mid] * (l) * (r);
            }
            stack.push(i);
        }
        return res;
    }
}
