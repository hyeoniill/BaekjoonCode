import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        for(int i=0; i<info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        
        dfs(info, 0, 0, candidates);
        
        return answer;
    }
    
    void dfs(int[] info, int curSheep, int curWolf, List<Integer> candidates) {
        for(int i=0; i<candidates.size(); i++) {
            int curr = candidates.get(i);
            int nxtSheep = curSheep;
            int nxtWolf = curWolf;
            if(info[curr]==0) nxtSheep++;
            else nxtWolf++;

            if(nxtWolf>=nxtSheep) continue;
            answer = Math.max(answer, nxtSheep);
            
            List<Integer> nxtCandidates = new ArrayList<>(candidates);
            nxtCandidates.remove(i);
            nxtCandidates.addAll(graph.get(curr));
            dfs(info, nxtSheep, nxtWolf, nxtCandidates);
        }
    }
}