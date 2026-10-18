class Solution {
    public double angleClock(int hour, int minutes) {
        //30 / 5: the degree of every minute
        //relation of hour and minute
        //5 minutes -> the postion of hour
        //60 / 5: 12 -> 1
        //6 * minutes - hours * degree???
        //hour angle = (hour / 12 + minutes/60) * 30
        int one_hour_angle = 30;
        int one_minute_angle = 6;
        
        double minutes_angle = minutes * one_minute_angle;
        double hour_angle = (hour % 12 + minutes / 60.0) * one_hour_angle;
        
        double diff = Math.abs(minutes_angle - hour_angle);
        return Math.min(diff, 360 - diff);
    }
}
