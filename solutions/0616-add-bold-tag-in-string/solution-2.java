class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        for (String word : words) {
            int start = 0;
            while (start != -1) {
                start = s.indexOf(word, start);
                if (start == -1) break;
                int end = start + word.length();
                for (int i = start; i < end; i++) {
                    bold[i] = true;
                }
                start++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i] && (i == 0 || !bold[i-1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (bold[i] && (i == s.length() - 1 || !bold[i+1])) {
                sb.append("</b>");
            }
        }
        
        return sb.toString();
    }
}
