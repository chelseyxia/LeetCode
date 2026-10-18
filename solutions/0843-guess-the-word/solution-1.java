/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        LinkedList<String> wl = new LinkedList(Arrays.asList(wordlist));
        for(int i = 0; i < 10; i++){
            String word = wl.get(wl.size() / 2);
            int num = master.guess(word);
            if(num == 6){
                break;
            }
            wl.removeIf(w -> numOfMatched(w, word) != num || w == word);
        }
    }
    
    private int numOfMatched(String a, String b){
        int num = 0;
        for(int i = 0; i < 6; i++){
            if(a.charAt(i) == b.charAt(i)){
                num++;
            }
        }
        
        return num;
    }
}
