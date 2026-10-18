class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> cnt = new ArrayList();
        int point = 0; 
        int n = s.length();
        while(point < n){
            int count = 0;
            char ch = s.charAt(point);
            while(point < n && ch == s.charAt(point)){
                count++;
                point++;
            }
            cnt.add(count);
        }
        int ans = 0;
        for(int i = 1; i < cnt.size(); i++){
            ans += Math.min(cnt.get(i), cnt.get(i - 1));
        }
        return ans;
    }
}
