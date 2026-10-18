class Solution {
    public int numUniqueEmails(String[] emails) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();
        
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            int n = email.length();
            String[] array = email.split("@");
            String domain = array[1];
            String local = array[0];
            for(int i = 0; i < local.length(); i++){
                char ch = local.charAt(i);
                if(ch != ('.') && ch != ('+')){
                    sb.append(ch);
                }
                if(ch == ('.')){
                    continue;
                }
                if(ch == ('+')){
                    break;
                }
            }
            map.putIfAbsent(domain, new HashSet<>());
            map.get(domain).add(sb.toString());
        }
        for(String str : map.keySet()){
            Set<String> s = map.get(str);
            ans += s.size();
        }
        return ans;
    }
}
