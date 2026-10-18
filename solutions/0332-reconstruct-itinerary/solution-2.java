class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> adjacents = new HashMap<>();
        
        for(List<String> ticket : tickets){
            String start = ticket.get(0);
            String destination = ticket.get(1);
            if(!adjacents.containsKey(start)){
                adjacents.put(start, new PriorityQueue<String>());
            }
            adjacents.get(start).offer(destination);
        }
        dfs(itinerary, adjacents, "JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }
    public void dfs(List<String> itinerary, HashMap<String, PriorityQueue<String>> adjacents, String s){
        //when to stop?
        while(adjacents.containsKey(s) && adjacents.get(s).size() > 0){
            String temp = adjacents.get(s).poll();
            dfs(itinerary, adjacents, temp);
        }
        itinerary.add(s);
    }
}
