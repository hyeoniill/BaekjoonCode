import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        int answer = 0;
        dfs("", visited, numbers);
        
        for(int num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer; 
    }
    
    void dfs(String curr, boolean[] visited, String numbers) {
        if(curr.length()!=0) set.add(Integer.parseInt(curr));
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i]=true;
                dfs(curr+numbers.charAt(i), visited, numbers);
                visited[i]=false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if(n<2) return false;
        for(int i=2; i*i<=n; i++) {
            if(n%i==0) return false;
        }
    return true;
    }
}