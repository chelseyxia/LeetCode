class Solution {
    HashSet<String> visited = new HashSet();
    HashMap<String, List<String>> adjacent = new HashMap();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountsListSize = accounts.size();
        
        for(List<String> account : accounts){
            int accountSize = account.size();
            String account1stEmail = account.get(1);
            
            for(int j = 2; j < accountSize; j++){
                String accountEmail = account.get(j);
                
                if(!adjacent.containsKey(account1stEmail)){
                    adjacent.put(account1stEmail, new ArrayList<String>());
                }
                adjacent.get(account1stEmail).add(accountEmail);
                
                if(!adjacent.containsKey(accountEmail)){
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(account1stEmail);
            }
        }
        List<List<String>> mergeAccounts = new ArrayList();
        for(List<String> account : accounts){
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);
            if(!visited.contains(accountFirstEmail)){
                List<String> mergeAccount = new ArrayList();
                mergeAccount.add(accountName);
                DFS(mergeAccount, accountFirstEmail);
                Collections.sort(mergeAccount.subList(1, mergeAccount.size()));
                mergeAccounts.add(mergeAccount);
            }
        }
        
        
        return mergeAccounts;
    }
    
    public void DFS(List<String> mergeAccount, String email){
        visited.add(email);
        mergeAccount.add(email);
        if(!adjacent.containsKey(email)){
            return;
        }
        
        for(String neighbor : adjacent.get(email)){
            if(!visited.contains(neighbor)){
                DFS(mergeAccount, neighbor);
            }
        }
    }
}
