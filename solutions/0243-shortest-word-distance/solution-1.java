class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        //List<Integer> lis;
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            String s = wordsDict[i];
            if(s.equals(word1)){
                index1 = i;
            }
            if(s.equals(word2)){
                index2 = i;
            }
            if(index1 != -1 && index2 != -1){
                distance = Math.min(distance, Math.abs(index1 - index2));     
            }
        }
        return distance;
    }
}
