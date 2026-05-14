import java.util.*;
class Solution {
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    public int solution(String[] maps) {
        int[] start = null;
        int[] end = null;
        int[] lever = null;
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        
        //지도 탐색하면서 시작점, 출구, 레버 위치를 찾음        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j)=='S') start = new int[]{i, j, 0};
                if(maps[i].charAt(j)=='E') end = new int[]{i, j, 0};
                if(maps[i].charAt(j)=='L') lever = new int[]{i, j, 0};
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(start);
        
        lever = bfs(queue, lever, maps, visited);
        if(lever==null) return -1;
        
        queue.clear();
        queue.offer(lever);
        for(boolean[] b : visited) Arrays.fill(b, false);
        
        visited[lever[0]][lever[1]] = true;
        end = bfs(queue, end, maps, visited);
        
        return end!=null ? end[2] : -1;
    }
    
    int[] bfs(Queue<int[]> queue, int[] target, String[] maps, boolean[][] visited) {
        do{
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if(x==target[0] && y==target[1]) return cur;
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length() && !visited[nx][ny] && maps[nx].charAt(ny)!='X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cur[2]+1});
                }
            }
        }while(!queue.isEmpty());
        
        return null;
    }
}