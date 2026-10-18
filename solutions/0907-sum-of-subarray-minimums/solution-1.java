class Solution {
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int MOD = 1_000_000_007;
        Stack<Integer> stackL = new Stack<>();
        Stack<Integer> stackR = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++){
            while(!stackL.isEmpty() && arr[i] <= arr[stackL.peek()]){
                stackL.pop();
            }
            left[i] = stackL.isEmpty() ? -1 : stackL.peek();
            stackL.push(i);
        }

        for(int i = n-1; i >= 0; i--){
            while(!stackR.isEmpty() && arr[i] < arr[stackR.peek()]){
                stackR.pop();
            }
            right[i] = stackR.isEmpty() ? n : stackR.peek();
            stackR.push(i);
        }

        for(int i = 0; i < n; i++){
            int leftChoices = i - left[i];
            int rightChoices = right[i] - i;
            long contribution = (long) arr[i] * leftChoices * rightChoices;
            sum = (int)((sum + contribution) % MOD);
        }
        return sum;
    }
}
