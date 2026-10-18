class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.length() < abbr.length()){
            return false;
        }
        
        int i = 0, j = 0;
        while(i < abbr.length() && j < word.length()){
            if(word.charAt(j) == abbr.charAt(i)){
                i++;
                j++;
            }
            else if(Character.isDigit(abbr.charAt(i))){
                int index = i;
                while(i < abbr.length() && Character.isDigit(abbr.charAt(i))){
                    i++;
                }
                if(i > index && abbr.charAt(index) == '0'){
                    return false;
                }
                j += Integer.parseInt(abbr.substring(index, i));
            }
            else{
                return false;
            }
        }
        return (j == word.length() && i == abbr.length()) ? true : false;
    }
}
