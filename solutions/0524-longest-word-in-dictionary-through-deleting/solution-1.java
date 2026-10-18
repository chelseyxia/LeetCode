class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
        for(String word : dictionary){
            if(equals(s, word)){
                return word;
            }
        }
        return "";
    }
    
    private boolean equals(String s, String word){
        char[] c1 = s.toCharArray();
        char[] c2 = word.toCharArray();
        if(c2.length > c1.length){
            return false;
        }
        int index1 = 0, index2 = 0;
        while(index1 < c1.length && index2 < c2.length){
            while(index1 < c1.length && c1[index1] != c2[index2]){
                index1++;
            }
            if(index1 >= c1.length){
                break;
            }
            index1++;
            index2++;
            if((c1.length - index1) < (c2.length - index2)){
                return false;
            }
        }
        return index2 == c2.length;
    }
}
