class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] letter = new int[26];
        for(int i = 0; i < s.length(); i++){
            letter[s.charAt(i) - 'a'] = i;//store s's letters into an array,need to use them later
        }
        int boundary = 0;
        int count = 0;
        List<Integer> ans = new ArrayList<>();//return an array
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);//record every letter
            boundary = Math.max(boundary, letter[ch - 'a']);
            count++;
            if(i == boundary){
                ans.add(count);
                count = 0;
            }
        }
        return ans;
    }
}
