class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dic = new int[26];//dic has 26 alphabet
        for(int i = 0; i < order.length(); i++){//store 26 alphabet into array
            dic[order.charAt(i) - 'a'] = i;//alphabet is the index, number is value
        }
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j >= words[i + 1].length()){
                    return false;
                }
                if(words[i].charAt(j) != words[i + 1]. charAt(j)){
                    int cur = words[i].charAt(j) - 'a';
                    int next = words[i + 1].charAt(j) - 'a';
                    if(dic[cur] > dic[next]){
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
