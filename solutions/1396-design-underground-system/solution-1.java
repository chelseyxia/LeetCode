class UndergroundSystem {
    private HashMap<String, Pair<Double, Double>> journeyData = new HashMap();
    private HashMap<Integer, Pair<String, Integer>> checkInData = new HashMap();
    public UndergroundSystem() {

    }
    
    public void checkIn(int id, String stationName, int t) {
        this.checkInData.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInDataForId = checkInData.get(id);
        String startStation = checkInDataForId.getKey();
        Integer checkInTime = checkInDataForId.getValue();
        
        String routeKey = stationKey(startStation, stationName);
        
        Pair<Double, Double> routeStats = journeyData.getOrDefault(routeKey, new Pair<>(0.0, 0.0));
        Double tatalTripTime = routeStats.getKey();
        Double totalTrips = routeStats.getValue();
        
        double tripTime = t - checkInTime;
        journeyData.put(routeKey, new Pair<>(tatalTripTime + tripTime, totalTrips + 1));
        
        checkInData.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = stationKey(startStation, endStation);
        Double totalTime = journeyData.get(routeKey).getKey();
        Double totalTrips = journeyData.get(routeKey).getValue();
        return totalTime / totalTrips;
    }
    
    private String stationKey(String startStation, String endStation){
        return startStation + "->" + endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
