class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, target, numbers, 0);
        return answer;
    }
    
    void dfs(int curr, int target, int[] numbers, int idx) {
        if(idx==numbers.length) {
            if(curr==target) answer++;
            return;
        }
        dfs(curr+numbers[idx], target, numbers, idx+1);
        dfs(curr-numbers[idx], target, numbers, idx+1);
    }
}