class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //1. the first letter is not same
        //the first letter is same
        int[] orderMap = new int[26];
        for(int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }
        int n = words.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j >= words[i + 1].length()){
                    return false;
                }
                if(words[i].charAt(j) != words[i + 1].charAt(j)){
                    int currch1 = words[i].charAt(j) - 'a';
                    int currch2 = words[i + 1].charAt(j) - 'a';
                    if(orderMap[currch1] > orderMap[currch2]){
                        return false;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        
        return true;
    }
}
