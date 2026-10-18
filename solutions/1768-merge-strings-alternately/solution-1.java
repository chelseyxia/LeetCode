class Solution {
    public String mergeAlternately(String word1, String word2) {
        //compare the length of each string
        int length1 = word1.length();
        int length2 = word2.length();
        //use which string to store the result
        String result = "";
        int length = length1 <= length2 ? length1 : length2;
        int l = 0;
        //3: 0, 1, 2
        while(l < length){
            char a = word1.charAt(l);
            char b = word2.charAt(l);
            result += a;
            result += b;
            l++;
        }
        //3 vs 5
        String subString = length1 >= length2 ? word1.substring(l, length1) : word2.substring(l, length2);
        result = result.concat(subString);
        return result;
    }
}
