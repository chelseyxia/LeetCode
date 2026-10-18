class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        for(String cpdomain : cpdomains){
            int spaceIndex = cpdomain.indexOf(" ");
            int temp = Integer.parseInt(cpdomain.substring(0, spaceIndex));
            String domain = cpdomain.substring(spaceIndex + 1);
            int i = 0;
            while(domain != null){
                map.put(domain, map.getOrDefault(domain, 0) + temp);
                int idx = domain.indexOf(".");
                if(idx == -1){
                    break;
                }
                domain = domain.substring(idx + 1);
            }
        }
        List<String> ans = new ArrayList();
        for(String s : map.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(s)).append(" ").append(s);
            ans.add(sb.toString());
        }
        return ans;
    }
}
