class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[128];
        for(char c : p.toCharArray()){
            cnt[c]++;
        }
        int lo = 0;
        int hi = 0;
        List<Integer> list = new ArrayList();
        while(hi < s.length()){
            if(cnt[s.charAt(hi)] > 0){
                cnt[s.charAt(hi++)]--;
                if(hi - lo == p.length()){
                    list.add(lo);
                }
            }
            else{
                cnt[s.charAt(lo++)]++;
            }
        }
        
        return list;
    }
}
