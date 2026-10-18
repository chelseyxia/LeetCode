class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // Pattern:
        // Next Greater Element + Monotonic Decreasing Stack
    // State:
        // Stack 保存已经扫描过、但 Next Greater 尚未确定的元素。
        // Map 保存每个元素对应的 Next Greater。
    // Invariant:
        // Stack 从 bottom 到 top 单调递减。
        // Stack 中所有元素都还没有找到 Next Greater。
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums1.length;
        int m = nums2.length;
        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                //While the stack is not empty and num is greater than the stack’s top element, keep popping because num is the next greater element for every popped value.
                int smaller = stack.pop();
                nextGreater.put(smaller, num);
            }
            stack.push(num);
        }
        //After scanning the entire array, any elements remaining in the stack never encountered a greater element on their right, so their Next Greater Element is -1.
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            if(nextGreater.containsKey(nums1[i])){
                int nG = nextGreater.get(nums1[i]);
                ans[i] = nG;
            }
            else{
                ans[i] = -1;
            }
        }
        return ans;
    }
}
