class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<List<String>>();
        HashMap<Integer, List<String>> anagrams = new HashMap<>();
        for (String s : strs){
          int key = getID(s);

          if (anagrams.containsKey(key)){
            anagrams.get(key).add(s);
          }else{
            List<String> newGroup = new ArrayList<String>();
            newGroup.add(s);
            anagrams.put(key, newGroup);
          }
        }
        output.addAll(anagrams.values());
        return output;
      }
      public static int getID(String s){
        int[] freqs = new int[26];
        for (char c : s.toCharArray()){
          freqs[c - 'a'] += 1;
        }
        return Arrays.hashCode(freqs);
      }
}
