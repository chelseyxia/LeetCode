class Solution {
    public int singleNumber(int[] nums) {
        //linear time complexity
        //constant extra space
        Queue<Integer> q = new ArrayDeque();
        for(int i = 0; i < nums.length; i++){
            if(q.contains(nums[i])){
                q.remove(nums[i]);
            }
            else{
                q.add(nums[i]);       
            }
        }
        return q.peek();
    }
}
