class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int rk = -1; 
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(rk + 1 < n && !set.contains(s.charAt(rk + 1))){
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
