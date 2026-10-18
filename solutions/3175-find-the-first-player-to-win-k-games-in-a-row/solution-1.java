class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int champ = 0;
        int wins = 0;
        for(int i = 1; i < skills.length; i++){
            if(wins == k){
                return champ;
            }
            if(skills[champ] > skills[i]){
                wins++;
            }
            else{
                champ = i;
                wins = 1;
            }
        }
        return champ;
    }
}
