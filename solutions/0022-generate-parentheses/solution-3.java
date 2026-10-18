class Solution {
    public List<String> generateParenthesis(int n) {
        //backTrack
        List<String> list = new ArrayList();
        backTracking(list, new StringBuilder(), 0, 0, n);
        return list;
    }
    private void backTracking(List<String> list, StringBuilder sb, int open, int close, int max){
        if(sb.length() == max * 2){
            list.add(sb.toString());
            return;
        }
        if(open < max){
            sb.append('(');
            backTracking(list, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(')');
            backTracking(list, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
