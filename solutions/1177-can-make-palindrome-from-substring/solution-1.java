class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[] alpha = new int[s.length()];
        List<Boolean> ans = new ArrayList<Boolean>();
        alpha[0] = (1 << (s.charAt(0) - 'a'));
        
        for(int i = 1; i < s.length(); i++){
            alpha[i] = alpha[i - 1] ^ (1 << (s.charAt(i) - 'a'));
        }
        
        for(int[] query : queries){
            if(query[0] == 0){
                ans.add(countBits(alpha[query[1]]) / 2 <= query[2]);
            }
            else{
                ans.add(countBits(alpha[query[0] - 1] ^ alpha[query[1]]) / 2 <= query[2]);
            }
        }
        
        return ans;
    }
    
    private int countBits(int n){
        int cnt = 0;
        while(n != 0){
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }
}
