/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Interval> queue = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(s -> queue.addAll(s));
        
        List<Interval> list = new ArrayList();
        int lastEnd = queue.remove().end;
        while(!queue.isEmpty()){
            Interval popped = queue.remove();
            if(popped.start > lastEnd){
                list.add(new Interval(lastEnd, popped.start));
            }
            lastEnd = Math.max(lastEnd, popped.end);
        }
        
        return list;
    }
}
//1 3     6 7    
//2 4   
//2 5     9 12


//1 2     5 6: 2 - 5
//1 3        ：3 - ..
//4 10       : 4 - ..
