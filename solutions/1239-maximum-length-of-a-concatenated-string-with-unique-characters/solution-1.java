class Solution {
    public int maxLength(List<String> arr) {
        return dfs(arr, 0, "");
    }
    private int dfs(List<String> arr, int idx, String res){
        Set<Character> set = new HashSet();
        for(char ch : res.toCharArray()){
            set.add(ch);
        }
        if(res.length() != set.size()){
            return 0;
        }
        int best = res.length();
        for(int i = idx; i < arr.size(); i++){
            best = Math.max(best, dfs(arr, i + 1, res + arr.get(i)));
        }
        return best;
    }
}
