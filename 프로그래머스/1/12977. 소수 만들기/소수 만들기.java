class Solution {
    public int solution(int[] nums) {
        
        int len = nums.length;
        int count = 0;
        
        for(int i=0; i<len-2; i++) {
            for(int j=i+1; j<len-1; j++) {
                for(int k=j+1; k<len; k++) {
                    if(isPrime(nums[i]+nums[j]+nums[k])) count++;
                }
            }
        }

        return count;
    }
    boolean isPrime(int k) {
        for(int i=2; i*i<=k; i++) {
            if(k%i==0) return false;
        }
        return true;
    }
}