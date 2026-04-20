import java.io.*;
import java.util.*;

class Solution {
    static int[][] tree;
    static int[][] treeSum;
    
    public int solution(int[][] triangle) {
        tree = triangle;
        treeSum = new int[tree.length][];
        for(int i=0; i<tree.length; i++) {
            treeSum[i] = new int[i+1];
            Arrays.fill(treeSum[i], -1);
        }
        
        return calc(0,0);
    }
    
    public int calc(int degree, int currentIndex) {
        if(degree == tree.length) {
            return 0;
        }
        
        int current = tree[degree][currentIndex];
        int Calculated = treeSum[degree][currentIndex];
        
        if(Calculated != -1) {
            return Calculated;
        }
        
        int currentMax = Math.max(current + calc(degree+1, currentIndex), current + calc(degree+1, currentIndex+1));
        treeSum[degree][currentIndex] = currentMax;
        
        return currentMax;
    }
}