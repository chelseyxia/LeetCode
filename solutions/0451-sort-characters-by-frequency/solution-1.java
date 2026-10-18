class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Object[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                (Integer)b[1], (Integer)a[1]
            )
        );
        int size = 0;
        for(Map.Entry<Character, Integer> mapEntry : map.entrySet()){
            char c = mapEntry.getKey();
            int fre = mapEntry.getValue();
            minHeap.offer(new Object[]{c, fre});
            size++;
        }
        StringBuilder sb = new StringBuilder();
        while(!minHeap.isEmpty()){
            Object[] cur = minHeap.poll();
            char curChar = (Character)cur[0];
            int curFre = (Integer)cur[1];
            for(int i = 0; i < curFre; i++){
                sb.append(curChar);
            }
        }
        return sb.toString();
    }
}
