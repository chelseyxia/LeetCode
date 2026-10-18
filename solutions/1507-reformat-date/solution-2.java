class Solution {
    public String reformatDate(String date) {
        Map<String, String> map = new HashMap();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        String[] dateArr = date.split(" ");
        StringBuilder ans = new StringBuilder();
        ans.append(dateArr[2]);
        ans.append("-");
        ans.append(map.get(dateArr[1]));
        ans.append("-");
        String s = dateArr[0];
        int day = 0;
        StringBuilder d = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                day = day * 10 + (ch - '0');
                //d.append(ch);
            }
        }
        if(day < 10){
            ans.append(0);
        }
        ans.append(day);
        
        
        return ans.toString();
    }
}
