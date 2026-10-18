class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Map.Entry <Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            maxHeap.offer(entry);
        }
        Character pendingChar = null;
        int pendingVal = -1;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            int length = sb.length();
            char key = entry.getKey();
            int value = entry.getValue();
            if(length != 0 && sb.charAt(length - 1) == key){
                return "";
            }
            sb.append(key);
            if(pendingChar != null && pendingChar != key && pendingVal > 0){
                maxHeap.offer(Map.entry(pendingChar, pendingVal));
            }
            pendingChar = key;
            pendingVal = value - 1;
        }
        if(pendingVal > 0){
            return "";
        }
        return sb.toString();
    }
}
