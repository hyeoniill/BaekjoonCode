import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int colLen = relation[0].length;
        int rowLen = relation.length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        for(int cols = 1; cols < (1 << colLen); cols++) {
            boolean isMinimal = true;
            for(int key : candidateKeys) {
                if((key & cols) == key) {
                    isMinimal = false;
                    break;
                }
            }
            if(!isMinimal) continue;
            
            Set<String> rowSet = new HashSet<>();
            for(String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for(int c=0; c<colLen; c++) {
                    if((cols & (1<<c)) != 0) {
                        sb.append(row[c]).append(",");
                    }
                }
                rowSet.add(sb.toString());
            }
            if(rowSet.size() == rowLen) {
                candidateKeys.add(cols);
            }
        }
        
        return candidateKeys.size();
    }
}