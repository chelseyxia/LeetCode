class Solution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap();
    
    static{
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);
    }
    
    public int evalRPN(String[] tokens) {
        int currPosition = 0;
        int length = tokens.length;
        while(length > 1){
            while(!operations.containsKey(tokens[currPosition])){
                currPosition++;
            }
            String operation = tokens[currPosition];
            int num1 = Integer.parseInt(tokens[currPosition - 2]);
            int num2 = Integer.parseInt(tokens[currPosition - 1]);
            BiFunction<Integer, Integer, Integer> operator = operations.get(operation);
            int value = operator.apply(num1, num2);
            tokens[currPosition] = Integer.toString(value);
            delete2AtIndex(tokens, currPosition - 2, length);
            currPosition--;
            length -= 2;
        }
        return Integer.parseInt(tokens[0]);
    }
    
    public void delete2AtIndex(String[] tokens, int d, int length){
        for(int i = d; i < length - 2; i++){
            tokens[i] = tokens[i + 2];
        }
    }
}
