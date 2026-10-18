class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] ans = new int[26];
        for(int i = 0; i < s.length(); i++){
            ans[s.charAt(i) - 'a'] = i;
        }
        int boundary = 0; 
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            boundary = Math.max(boundary, ans[ch - 'a']);
            cnt++;
            if(i == boundary){
                res.add(cnt);
                cnt = 0;
            } 
        }
        return res;
    }
}
