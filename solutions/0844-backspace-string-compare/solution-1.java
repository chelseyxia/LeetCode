class Solution {
    public boolean backspaceCompare(String s, String t) {
        /*char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int ns = s.length();
        int nt = t.length();
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        Stack<Character> stackS = new Stack();
        Stack<Character> stackT = new Stack();*/
        return rebuild(s).equals(rebuild(t));
    }
    public String rebuild(String s){
        Stack<Character> stackS = new Stack();
        
        for(char c : s.toCharArray()){
            if(c != '#'){
                stackS.add(c);
            }
            else if(!stackS.empty()){
                stackS.pop();
            }
        }
        
        return String.valueOf(stackS);
    }
}
