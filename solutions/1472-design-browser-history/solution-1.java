class BrowserHistory {
    List<String> a;
    int i;
    
    public BrowserHistory(String homepage) {
        a = new ArrayList();
        a.add(homepage);
        i = 0;
    }
    
    public void visit(String url) {
        a.subList(i + 1, a.size()).clear();
        a.add(url);
        i++;
    }
    
    public String back(int steps) {
        i = Math.max(0, i - steps);
        return a.get(i);
    }
    
    public String forward(int steps) {
        i = Math.min(i + steps, a.size() - 1);
        return a.get(i);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
