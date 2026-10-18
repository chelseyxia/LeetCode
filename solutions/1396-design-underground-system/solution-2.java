class UndergroundSystem {
    static class CheckIn{
        String stationName;
        int t;
        CheckIn(String s, int t){
            this.stationName = s;
            this.t = t;
        }
    }
    
    static class CheckOut{
        int totalTime;
        int totalCount;
        CheckOut(int tt, int tc){
            this.totalTime = tt;
            this.totalCount = tc;
        }
    }
    
    Map<Integer, CheckIn> checkInMap = new HashMap();
    Map<String, Map<String, CheckOut>> checkOutMap = new HashMap();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);
        String start = checkIn.stationName;
        if(!checkOutMap.containsKey(start)){
            checkOutMap.put(start, new HashMap());
        }
        CheckOut checkOut = checkOutMap.get(start).getOrDefault(stationName, new CheckOut(0, 0));
        checkOut.totalCount += 1;
        checkOut.totalTime += t - checkIn.t;
        checkOutMap.get(start).put(stationName, checkOut);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        CheckOut checkout = checkOutMap.get(startStation).get(endStation);
        return (double) checkout.totalTime / checkout.totalCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
