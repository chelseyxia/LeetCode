/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weigh = weight(nestedList);
        return dfs(nestedList, 1, weigh);
        
    }
    public int dfs(List<NestedInteger> nestedList, int index, int weigh){
        int sum = 0;
        for(NestedInteger list : nestedList){
            if(list.isInteger()){
                sum += ((weigh - index) + 1) * (list.getInteger());
            }
            else{
                sum += dfs(list.getList(), index + 1, weigh);
            }
        }
        
        return sum;
    }
    public int weight(List<NestedInteger> nestedList){
        int maxDepth = 1;
        for(NestedInteger list : nestedList){
            if(!list.isInteger()){
                maxDepth = Math.max(maxDepth, 1 + weight(list.getList()));
            }
        }
        return maxDepth;
    }
}
