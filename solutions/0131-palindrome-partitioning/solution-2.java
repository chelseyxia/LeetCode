class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(List<List<String>> res, String s, int start, List<String> path){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String cur = s.substring(start, i + 1);
            if(!ispalindrome(cur)){
                continue;
            }
            path.add(cur);
            backtrack(res, s, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
    public boolean ispalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
