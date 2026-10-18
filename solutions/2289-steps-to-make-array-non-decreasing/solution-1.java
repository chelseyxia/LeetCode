class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int answer = 0;
        for(int num : nums){
            int step = 0;
            while(!stack.isEmpty() && num >= stack.peek()[0]){
                step = Math.max(step, stack.pop()[1]);
            }
            if(!stack.isEmpty()){
                step++;
            }
            else{
                step = 0;
            }
            answer = Math.max(answer, step);
            stack.push(new int[]{num, step});
        }
        return answer;
    }
}
