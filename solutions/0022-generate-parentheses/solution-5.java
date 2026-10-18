class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack(0, 0, res, path, n);
        return res;
    }
    public void backtrack(int open, int close, List<String> res, StringBuilder s, int n){
        if(s.length() == n * 2){
            res.add(s.toString());
            return;
        }
        if(open > close){
            s.append(')');
            backtrack(open, close + 1, res, s, n);
            s.deleteCharAt(s.length() - 1);
        }
        if(open < n){
            s.append('(');
            backtrack(open + 1, close, res, s, n);  
            s.deleteCharAt(s.length() - 1);
        }
    }
}
