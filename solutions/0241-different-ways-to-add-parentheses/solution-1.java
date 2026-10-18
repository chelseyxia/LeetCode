class Solution {
    HashMap<String, List<Integer>> map = new HashMap();
    public List<Integer> diffWaysToCompute(String expression) {
        //base case
        if(expression.length() == 0){
            return new ArrayList();
        }
        
        //if exist
        if(map.containsKey(expression)){
            return map.get(expression);
        }
        
        List<Integer> res = new ArrayList();
        int num = 0;
        int index = 0;
        //initial num's value
        while(index < expression.length() && !isOperation(expression.charAt(index))){
            num = num * 10 + expression.charAt(index) - '0';
            index++;
        }
        
        if(index == expression.length()){
            res.add(num);
            map.put(expression, res);
            return res;
        }
        //承接while loop, while isOperation
        for(int i = 0; i < expression.length(); i++){
            if(isOperation(expression.charAt(i))){
                //start recursion
                List<Integer> result1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(expression.substring(i + 1));
                
                //nest for loop
                for(int j = 0; j < result1.size(); j++){
                    for(int k = 0; k < result2.size(); k++){
                        char op = expression.charAt(i);
                        res.add(calculate(result1.get(j), op, result2.get(k)));
                    }
                }
            }
        }
        
        map.put(expression, res);
        return res;
    }
    
    private int calculate(int num1, char c, int num2){
        switch(c){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }
    
    private boolean isOperation(char c){
        return c == '+' || c == '*' || c == '-';
    }
}
