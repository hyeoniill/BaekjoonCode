import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {       
        if(cacheSize==0) return cities.length * 5;
        Queue<String> queue = new ArrayDeque<>();
        int answer = 0;
        
        for(int i=0; i<cities.length; i++) {
            String cur = cities[i].toLowerCase();
            if(queue.contains(cur)) {
                queue.remove(cur);
                queue.offer(cur);
                answer += 1;
            } else {
                if(queue.size()==cacheSize) {
                    queue.poll();
                }
                queue.offer(cur);
                answer += 5;
            }
        }
        return answer;
    }
    

}