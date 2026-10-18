class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();      
        //odd palindrone || even palindrone
        for(int start = 0; start < n; start++){
            for(int end = start; end < n; end++){
                res += isPalindrone(start, end, s) ? 1 : 0;
            }
        }
        
        return res;
    }
    
    private boolean isPalindrone(int start, int end, String s){
        while(start < end){//no equal?
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
