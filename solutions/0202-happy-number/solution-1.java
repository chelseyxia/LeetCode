class Solution {
    private int getNext(int n){
        if(n <= 0){
            return 0;
        }     
        return (int) Math.pow(n % 10, 2) + getNext(n / 10);
    }
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
              return n == 1;
    }
}


//11
//1234/10 = 4
