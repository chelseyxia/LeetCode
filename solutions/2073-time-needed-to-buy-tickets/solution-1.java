class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        if(tickets[k] == 1){
            return k + 1;
        }
        int t = tickets[k];
        int time = 0;
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i] != 0){
                tickets[i]--;
                time++;
            }
            if(i == k && tickets[k] == 0){
                return time;
            }
            if(i == tickets.length - 1){
                i = -1;
            }
        }
        return -1;
    }
}

//0 1 2 1 1 2
