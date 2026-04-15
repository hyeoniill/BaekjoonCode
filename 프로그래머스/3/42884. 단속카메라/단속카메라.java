import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int camera = 1;
        //끝 지점을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int position = routes[0][1];
        
        for(int i=1; i<routes.length; i++) {
            if(routes[i][0] > position) {
                camera++;
                position = routes[i][1];
            }
        }
        
        return camera;
    }
}

