import java.util.*;

class Solution {
            int max = 0;
    
    public int solution(int k, int[][] dungeons) {

        List<Node> list = new ArrayList<>();
        for(int i=0; i<dungeons.length; i++) {
            list.add(new Node(dungeons[i][0], dungeons[i][1]));   
        }
        
        for(int i=0; i<list.size(); i++) {
            visit(list.get(i), list, k, 0);
        }
        
        
        
        return max;
    }
    
    public void visit(Node currentNode, List<Node> list, int currentFP, int count) {
        if(currentFP < currentNode.minimumFP) {
            max = Math.max(max, count);
            return;
        }
        currentFP -= currentNode.FP;
        currentNode.visited = true;
        count++;
        
        max = Math.max(max, count);
        
        for(Node n : list) {
            if(!n.visited) {
                visit(n, list, currentFP, count);
            }
        }
        currentNode.visited = false;
    }    
}

class Node {
    int FP = 0;
    int minimumFP = 0;
    boolean visited = false;

    public Node(int minimumFP, int FP) {
        this.FP = FP;
        this.minimumFP = minimumFP;
    }
}
