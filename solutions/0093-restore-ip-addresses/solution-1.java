class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        backTracking(s, ans, sb, 0, 0);
        return ans;
    }
    private void backTracking(String s, List<String> ans, StringBuilder sb, int idx, int cnt){
        if(idx == s.length() && cnt == 4){
            ans.add(sb.toString());
            return;
        }
        if(cnt == 4){
            return;
        }
        
        for(int i = idx; i < s.length(); i++){
            String curr = s.substring(idx, i + 1);
            int temp = Integer.parseInt(curr);
            if(temp > 255){
                return;
            }
            if(curr.length() > 1 && curr.charAt(0) == '0'){
                return;
            }
            if(temp >= 0 && temp <= 255){
                StringBuilder rollback = new StringBuilder(sb);
                sb.append(s.substring(idx, i + 1));
                if(cnt < 3){
                    sb.append(".");
                }
                backTracking(s, ans, sb, i + 1, cnt + 1);
                sb = rollback;
            }
            
        }
    }
}
