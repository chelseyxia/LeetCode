class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        backTracking(n, list, sb, 0, 0);
        return list;
    }
    private void backTracking(int n, List<String> ans, StringBuilder sb, int open, int close){
        if(sb.length() == n * 2){
            ans.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            backTracking(n, ans, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(open > close){
            sb.append(')');
            backTracking(n, ans, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
