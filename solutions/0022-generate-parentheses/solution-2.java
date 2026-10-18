class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backTrack(ans, new StringBuffer(), 0, 0, n );
        return ans;
    }
    public void backTrack(List<String> ans, StringBuffer cur, int i, int j, int n){
        //base case
        if(cur.length() == n * 2){
            ans.add(cur.toString());
            return;
        }
        if(i < n){
            cur.append("(");
            backTrack(ans, cur, i + 1, j, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(j < i){
            cur.append(")");
            backTrack(ans, cur, i, j + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
