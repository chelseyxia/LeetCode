/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int numOfPeople;
    public int findCelebrity(int n) {
        //we can find the candidate to down the time complexity to O(n)
        numOfPeople = n;
        int celebrityCandidate = 0;
        
        for(int i = 0; i < n; i++){
            if(knows(celebrityCandidate, i)){
                celebrityCandidate = i;
            }
        }
        
        if(isCelebrity(celebrityCandidate)){
            return celebrityCandidate;
        }
        return -1;
    }
    
    private boolean isCelebrity(int i){
        for(int j = 0; j < numOfPeople; j++){
            if(i == j){
                continue;
            }
            if(knows(i, j) || !knows(j, i)){
                return false;
            }
        }
        
        return true;
    }
}

//      0 1 2

// 0    1 1 0
// 1    0 1 0
// 2    1 1 1

// 0    1 0 1
// 1    1 1 0
// 2    0 1 1
