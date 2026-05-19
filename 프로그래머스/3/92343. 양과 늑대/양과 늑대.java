import java.util.*;
class Solution {
    List<List<Integer>> tree = new ArrayList<>();
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        for(int i=0; i<info.length; i++) {
            tree.add(new ArrayList<>());
        }
        //트리니까 단방향
        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }
        
        List<Integer> nxtNodes = new ArrayList<>();
        nxtNodes.add(0);
        
        dfs(info, 0, 0, nxtNodes);
        
        return answer;
    }
    
    void dfs(int[] info, int sheep, int wolf, List<Integer> candidates) {
        for(int i=0; i<candidates.size(); i++) {
            int curr = candidates.get(i);
            
            int nxtSheep = sheep;
            int nxtWolf = wolf;
            
            if(info[curr]==0) nxtSheep++;
            else nxtWolf++;
            
            if(nxtWolf >= nxtSheep) continue;
            
            answer = Math.max(answer, nxtSheep);
            
            List<Integer> nxtCandidates = new ArrayList<>(candidates);
            nxtCandidates.remove(i);
            nxtCandidates.addAll(tree.get(curr));
            
            dfs(info, nxtSheep, nxtWolf, nxtCandidates);
        }    
    }
}