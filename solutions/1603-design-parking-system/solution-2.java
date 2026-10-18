class ParkingSystem {
    HashMap<Integer, Integer> map;
    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap();
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }
    
    public boolean addCar(int carType) {
        int remain = map.get(carType);
        if(remain > 0){
            map.put(carType, remain - 1);
            return true;
        }
        
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
