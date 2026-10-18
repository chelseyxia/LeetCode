class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = helper(slow);
            fast = helper(helper(fast));
        }while(slow != fast);
        return slow == 1;
    }
    private int helper(int n){
        int sum = 0;
        while(n != 0){
            //int remain = n % 10;
            sum += (n % 10) * (n % 10);
            n = n / 10; 
        }
        return sum;
    }
}
