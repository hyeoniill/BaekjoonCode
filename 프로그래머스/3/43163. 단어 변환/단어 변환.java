import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Map<String, Integer> dist = new HashMap<>();
        
        visited.add(begin);
        dist.put(begin, 0);
        
        Queue<String> word = new ArrayDeque<>();
        
        word.offer(begin);
        
        do {
            String cur = word.poll();
            if(cur.equals(target)) return dist.get(cur);
            for(String w : words) {
                int diff = 0;
                for(int i=0; i<w.length(); i++) {
                    if(cur.charAt(i)!=w.charAt(i)) {
                        diff++;
                    }
                }
                if(!visited.contains(w) && diff==1) {
                    word.offer(w);
                    visited.add(w);
                    dist.put(w, dist.get(cur)+1);
                }
            }
        }while(!word.isEmpty());
        
        
        return 0;
    }
}