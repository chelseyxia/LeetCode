class Solution {
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        //what data structure
        //sort?
        //hashmap: i: nums[i]....return the longest length
        int n = nums.length;
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        
        for(int num : set){
            if(!set.contains(num - 1)){
                int currNum = num;
                int currStreak = 1;
                
                while(set.contains(currNum + 1)){
                    currNum += 1;
                    currStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }    
        }
        
        return longestStreak;
    }
}
