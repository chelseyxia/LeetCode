/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<Integer>();
    private int position = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList(nestedList);
    }
    
    public void flattenList(List<NestedInteger> nextedList){
        for(NestedInteger nextInteger : nextedList){
            if(nextInteger.isInteger()){
                list.add(nextInteger.getInteger());
            }
            else{
                flattenList(nextInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return list.get(position++);
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
