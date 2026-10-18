class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                map.get(b), map.get(a)
            )
        );
        for(Map.Entry<Character, Integer> mapEntry : map.entrySet()){
            char c = mapEntry.getKey();
            maxHeap.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char curChar = maxHeap.poll();
            for(int i = 0; i < map.get(curChar); i++){
                sb.append(curChar);
            }
        }
        return sb.toString();
    }
}
