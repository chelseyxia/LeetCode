class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.length() == 0){
            return ans;
        }
        backTrack(ans, map, digits, 0, new StringBuffer());
        return ans;
    }
    public void backTrack(List<String> ans, Map<Character, String> map, String digits, int index, StringBuffer combination ){
        if(index == digits.length()){
            ans.add(combination.toString());
        }
        else{
            char digit = digits.charAt(index);
            String letter = map.get(digit);
            int n = letter.length();
            for(int i = 0; i < n; i++){
                combination.append(letter.charAt(i));
                backTrack(ans, map, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
