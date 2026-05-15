import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] data : edge) {
            graph.get(data[0]).add(data[1]);
            graph.get(data[1]).add(data[0]);
        }
        
        
        Queue<Integer> queue = new ArrayDeque<>();
        dist[1] = 1;
        queue.offer(1);
        
        do {
            int cur = queue.poll();
            
            for(int nxt : graph.get(cur)) {
                if(dist[nxt]==0) {
                    dist[nxt] = dist[cur]+1;
                    queue.offer(nxt);
                }
            }
        } while(!queue.isEmpty());
        
        int max = Arrays.stream(dist).max().orElse(-1);
        
        
        
        return (int)Arrays.stream(dist).filter(x -> x==max).count();
    }
}