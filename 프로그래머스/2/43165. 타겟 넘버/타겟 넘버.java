class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    void dfs(int[] numbers, int target, int curr, int idx) {
        if(numbers.length==idx) {
            if(target==curr) answer++;
            return; 
        }
        dfs(numbers, target, curr+numbers[idx], idx+1);   dfs(numbers, target, curr-numbers[idx], idx+1);
    }
}