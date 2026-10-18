class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        backtrack(digits, mapping, 0, new StringBuilder(), res);
        return res;
    }
    public void backtrack(String digits, String[] mapping, int index, StringBuilder path, List<String> res){
        if(path.length() == digits.length()){
            res.add(path.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        String cur = mapping[num];
        for(int i = 0; i < cur.length(); i++){
            path.append(cur.charAt(i));
            backtrack(digits, mapping, index + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }

        

    }
}
