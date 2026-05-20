import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    void dfs(int kCur, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        for(int i=0; i<dungeons.length; i++) {
            int kMin = dungeons[i][0];
            int kNeed = dungeons[i][1];
            
            if(!visited[i] && kCur>=kMin) {
                visited[i]=true;
                dfs(kCur-kNeed, dungeons, visited, count+1);
                visited[i]=false;
            }
        }    
    }
}
