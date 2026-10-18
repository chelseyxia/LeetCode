class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());
        for(int i = 0; i < n; ){
            //char ch = formula.charAt(i);
            if(formula.charAt(i) == '('){
                stack.push(new TreeMap());
                i++;
            }
            
            else if(formula.charAt(i) == ')'){
                Map<String, Integer> top = stack.pop();
                int iStart = ++i;
                int multi = 1;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                if(i > iStart){
                    multi = Integer.parseInt(formula.substring(iStart, i));
                }
                
                for(String c : top.keySet()){
                    int v = top.get(c);
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multi);
                }
            }
            
            else{
                int iStart = i++;
                while(i < n && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                
                while(i < n && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int multi = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multi);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(String name : stack.peek().keySet()){
            res.append(name);
            int multi = stack.peek().get(name);
            if(multi > 1){
                res.append("" + multi);
            }
        }
        return new String(res);
    }
}
