class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                //在内容不同时，忽略标识符，按内容字母顺序排序；
                int cmp = split1[1].compareTo(split2[1]);
                if(cmp != 0){
                    return cmp;
                }
                //在内容相同时，按标识符排序。
                return split1[0].compareTo(split2[0]);
            }
            //return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            else if(isDigit1 && isDigit2){
                return 0;
            }
            else if(!isDigit1){
                return -1;
            }
            else{
                return 1;
            }
            //if isDigit1 is true(log1数字类型的)，判断括号内容，isDigit2也是真，也就是log2也是数字，那么返回0，两者一样大，如果lsDigit2是假，不是数字，返回1，那么log1比log2大，首先应清楚两者在这里不可能同时为字母日志，上面已经判断过了，如果isDigit为假，则表示字母日志，那样isDigit2必为假，此时返回-1，也就是log1比log2小。
        });
        return logs;
    }
}
