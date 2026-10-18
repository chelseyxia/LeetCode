class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = num.length();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++){
            int cur = num.charAt(i) - '0';
            while(k > 0 && !deque.isEmpty() && cur < num.charAt(deque.peekLast()) - '0'){
                deque.pollLast();
                k--;
            }
            deque.offerLast(i);
        }
        while(!deque.isEmpty() && num.charAt(deque.peekFirst()) - '0' == 0){
            deque.pollFirst();
        }
        while(!deque.isEmpty() && k != 0){
            deque.pollLast();
            k--;
        }
        while(!deque.isEmpty()){
            ans.append(num.charAt(deque.pollFirst()));
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
