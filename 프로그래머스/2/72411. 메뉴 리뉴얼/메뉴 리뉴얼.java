import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int c : course) {
            Map<String, Integer> counter = new HashMap<>();
            
            for(String order : orders) {
                char[] menus = order.toCharArray();
                Arrays.sort(menus);
                dfs(menus, c, 0, new StringBuilder(), counter);
            }
            
            if(counter.isEmpty()) continue;
            
            int maxCount = Collections.max(counter.values());
            if(maxCount < 2) continue;
            
            for(String key : counter.keySet()) {
                if(counter.get(key)==maxCount) {
                    answer.add(key);
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
        
    }
    
    void dfs(char[] menus, int remain, int start, StringBuilder sb, Map<String, Integer> counter) {
        if(remain == 0) {
            String key = sb.toString();
            counter.put(key, counter.getOrDefault(key, 0) + 1);
            return;
        }
        
        for(int i=start; i<menus.length; i++) {
            sb.append(menus[i]);
            dfs(menus, remain-1, i+1, sb, counter);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}