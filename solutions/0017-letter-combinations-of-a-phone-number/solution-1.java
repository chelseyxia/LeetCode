class Solution {
    private Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits.length() == 0){
            return ans;
        }
        backtrack(ans, map, digits, 0, new StringBuffer());
        return ans;
    }
    public void backtrack(List<String> ans, Map<Character, String> phonemap, String digits, int index, StringBuffer combination){
        if(index == digits.length()){
            ans.add(combination.toString());
        }
        else{
            char digit = digits.charAt(index);
            String letters = phonemap.get(digit);
            int lettersCount = letters.length();
            for(int i = 0; i < lettersCount; i++){
                combination.append(letters.charAt(i));
                backtrack(ans, phonemap, digits, index+1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
