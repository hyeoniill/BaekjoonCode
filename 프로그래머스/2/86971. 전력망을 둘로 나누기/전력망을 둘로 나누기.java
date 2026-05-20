import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] subtree;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        subtree = new int[n+1];
        visited = new boolean[n+1];
        
        dfs(1);
        int answer = Integer.MAX_VALUE;
        
        for(int i=2; i<=n; i++) {
            int diff = Math.abs(n - 2*subtree[i]);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    
    int dfs(int node) {
        visited[node] = true;
        subtree[node] = 1;
        
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor);
                subtree[node] += subtree[neighbor];
            }
        }
        return subtree[node];
    }
}