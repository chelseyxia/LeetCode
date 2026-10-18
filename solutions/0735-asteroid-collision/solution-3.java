class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int a : asteroids){
            if(!stack.isEmpty() && stack.peek() > 0 && a < 0){//stack.peek() > 0 && a < 0
                int absCandidate = Math.abs(a);
                boolean destroyed = false;
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < absCandidate){
                        stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == absCandidate){
                    stack.pop();
                    destroyed = true;
                }
                if((!stack.isEmpty() && absCandidate < stack.peek())){
                    destroyed = true;
                }
                if(!destroyed){
                    stack.push(a);
                }
            }
            else{
                stack.push(a);
            }
        }
        int size = stack.size();
        if(size == 0){
            return new int[]{};
        }
        int[] res = new int[size];
        for(int i = 0; i < size; i++){
            res[size - i - 1] = stack.pop();
        }
        return res;
    }
}
