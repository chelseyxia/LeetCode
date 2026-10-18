class Solution {
    public int countVowelSubstrings(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int minLast = Integer.MAX_VALUE;
        int lastConsonant = -1;
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(isVowel(c)){
                map.put(c, i);
                if(map.size() == 5){
                    for(Map.Entry<Character, Integer> entry : map.entrySet()){
                        minLast = Math.min(minLast, entry.getValue());
                    }
                    count += minLast - lastConsonant;
                    minLast = Integer.MAX_VALUE;
                }
            }
            else{
                lastConsonant = i;
                map.clear();
            }
        }

        return count;
    }
    public boolean isVowel(char c){
        return switch (Character.toLowerCase(c)){
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}
