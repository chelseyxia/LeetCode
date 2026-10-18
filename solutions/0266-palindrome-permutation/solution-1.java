class Solution {
    public boolean canPermutePalindrome(String s) {
        //if the length is odd -> just one is single
        //if the length is even, no single
        int n = s.length();
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        
        for(char key : map.keySet()){
            count += map.get(key) % 2;
        }
        return count <= 1;
    }
}
