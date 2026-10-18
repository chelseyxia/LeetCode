class Logger {
    private HashMap<String, Integer> magDict;
    public Logger() {
        magDict = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.magDict.containsKey(message)){
            this.magDict.put(message, timestamp);
            return true;
        }
        int times = this.magDict.get(message);
        if(timestamp >= times + 10){
            this.magDict.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
