class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        long previous = 1;
        int top = rowIndex;
        for(int i = 1; i <= rowIndex; i++){
            previous = previous * top / i;
            top--;
            ans.add((int)previous);
        }
        return ans;
    }
}
