class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap();
        for(String domain : cpdomains){
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for(int i = frags.length - 1; i >= 0; --i){
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }
        
        List<String> ans = new ArrayList();
        for(String dom : map.keySet()){
            ans.add("" + map.get(dom) + " " + dom);
        }
        return ans;
    }
}
