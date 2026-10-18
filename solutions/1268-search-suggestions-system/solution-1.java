class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {        
        //sort the array and we can use binary search
        Arrays.sort(products);
        //create the result list
        List<List<String>> res = new ArrayList();
        int start = 0;
        int bsStart = 0;
        int n = products.length;
        //build a prefix string to store the prefix
        String prefix  = new String();
        for(char ch : searchWord.toCharArray()){
            prefix += ch;//fill the prefix string
            //call lower_bound
            start = lower_bound(products, bsStart, prefix);
            res.add(new ArrayList());
            
            for(int i = start; i < Math.min(start + 3, n); i++){
                if(products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix)){
                    break; 
                }
                res.get(res.size() - 1).add(products[i]);
            }
            bsStart = Math.abs(start);
        }     
        return res;
    }
    
    private int lower_bound(String[] products, int start, String word){
        int i = start;
        int j = products.length;
        int mid;
        while(i < j){
            mid = i + (j - i) / 2;
            if(products[mid].compareTo(word) >= 0){
                j = mid;
            }
            else{
                i = mid + 1;
            }
        }
        return i;
    }
}
