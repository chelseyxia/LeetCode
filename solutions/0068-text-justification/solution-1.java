class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //output: list<String> length of the string: maxWidth
        //for last line: left-aline
        List<String> list = new ArrayList();
        //int n = words.length;
        int count = 0; 
        int start = 0;
        for(int i = 0; i < words.length; i++){
            count += words[i].length();
                //how about n > maxWidth?
            if(count > maxWidth){
                list.add(helper(words, start, i - 1, maxWidth));
                start = i;
                count = words[i].length();
            }
            count++;
        }
        list.add(helper(words, start, words.length - 1, maxWidth));
        
        return list;
    }
    
    private String helper(String[] words, int start, int end, int maxWidth){
        StringBuilder sb = new StringBuilder();
        if(start == end){
            //one word one row
            oneWordOneRow(words, start, maxWidth, sb);
        }
        else if(end == words.length - 1){
            lastRow(words, start, end, maxWidth, sb);
        }
        else{
            normal(words, start, end, maxWidth, sb);
        }
        
        return sb.toString();
    }
    
    private void oneWordOneRow(String[] words, int start, int max, StringBuilder sb){
        sb.append(words[start]);
        int n = max - words[start].length();
        for(int i = 0; i < n; i++){
            sb.append(" ");
        }
    }
    
    private void lastRow(String[] words, int start, int end, int max, StringBuilder sb){
        for(int i = start; i <= end; i++){
            sb.append(words[i]);
            if(i != end){
                sb.append(" ");
            }
            else{
                int n = max - sb.length();
                for(int j = 0; j < n; j++){
                    sb.append(" ");
                }
            }
        }
    }
    
    private void normal(String[] words, int start, int end, int max, StringBuilder sb){
        int wordlength = 0;
        for(int i = start; i <= end; i++){
            wordlength += words[i].length();
        }
        int seperate = (max - wordlength) / (end - start);
        int remain = (max - wordlength) % (end - start);
        
        for(int i = start; i <= end; i++){
            sb.append(words[i]);
            if(i != end){
                for(int j = 0; j < seperate; j++){
                    sb.append(" ");                    
                }
                if(remain-- > 0){
                    sb.append(" ");
                }
            }
        }
    }
}
