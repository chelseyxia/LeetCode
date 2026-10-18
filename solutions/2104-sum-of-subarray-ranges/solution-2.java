class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> stackMinLeft = new Stack<>();
        Stack<Integer> stackMinRight = new Stack<>();
        Stack<Integer> stackMaxLeft = new Stack<>();
        Stack<Integer> stackMaxRight = new Stack<>();
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i = 0; i < n; i++){
            while(!stackMinLeft.isEmpty() && nums[i] <= nums[stackMinLeft.peek()]){
                stackMinLeft.pop();
            }
            leftMin[i] = stackMinLeft.isEmpty() ?  -1 : stackMinLeft.peek();
            stackMinLeft.push(i);
        }
        for(int i = n-1; i >= 0; i--){
            while(!stackMinRight.isEmpty() && nums[i] < nums[stackMinRight.peek()]){
                stackMinRight.pop();
            }
            rightMin[i] = stackMinRight.isEmpty() ? n : stackMinRight.peek();
            stackMinRight.push(i);
        }
        for(int i = 0; i < n; i++){
            while(!stackMaxLeft.isEmpty() && nums[i] > nums[stackMaxLeft.peek()]){
                stackMaxLeft.pop();
            }
            leftMax[i] = stackMaxLeft.isEmpty() ?  -1 : stackMaxLeft.peek();
            stackMaxLeft.push(i);
        }
        for(int i = n-1; i >= 0; i--){
            while(!stackMaxRight.isEmpty() && nums[i] >= nums[stackMaxRight.peek()]){
                stackMaxRight.pop();
            }
            rightMax[i] = stackMaxRight.isEmpty() ? n : stackMaxRight.peek();
            stackMaxRight.push(i);
        }
        long sumMin = 0, sumMax = 0;
        for(int i = 0; i < n; i++){
            int leftChoices = i - leftMin[i];
            int rightChoices = rightMin[i] - i;
            long contribution = (long) nums[i] * leftChoices * rightChoices;
            sumMin += contribution;
        }
        for(int i = 0; i < n; i++){
            int leftChoices = i - leftMax[i];
            int rightChoices = rightMax[i] - i;
            long contribution = (long) nums[i] * leftChoices * rightChoices;
            sumMax += contribution;
        }
        
        return sumMax - sumMin;
    }
}
