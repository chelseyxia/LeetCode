class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        Map<Character, Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            maxHeap.offer(entry);
        }
        int time = 0;
        while(!maxHeap.isEmpty()){
            int slots = n + 1;
            List<Map.Entry<Character, Integer>> pendingList = new ArrayList<>();
            while(slots > 0 && !maxHeap.isEmpty()){
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                char entryChar = entry.getKey();
                int entryFre = entry.getValue();
                int newFre = entryFre - 1;
                slots--;
                time++;
                if(newFre > 0){
                    pendingList.add(Map.entry(entryChar, newFre));
                }
            }
            for(int i = 0; i < pendingList.size(); i++){
                maxHeap.offer(pendingList.get(i));
            }
            if(!maxHeap.isEmpty()){
                time += slots;
            }
        }
        return time;
    }
}
