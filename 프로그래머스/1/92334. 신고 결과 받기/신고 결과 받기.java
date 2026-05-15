import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //index 저장
        Map<String, Integer> users = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
          users.put(id_list[i], i);   
        } 
        
        Set<String> set = new HashSet<>();
        for(String s : report) set.add(s);
        //신고된 사람: 신고한 사람 인덱스
        Map<String, ArrayList<Integer>> data = new HashMap<>(); 
        for(String s : set) {
            data.computeIfAbsent(s.split(" ")[1], n -> new ArrayList<>()).add(users.get(s.split(" ")[0]));
        }
        
        for(String reported : data.keySet()) {
            ArrayList<Integer> reporter = data.get(reported);
            if(reporter.size()>=k) {
                for(int n : reporter) {
                    answer[n]++;
                }
            } 
        }
        
        return answer;
    }
}