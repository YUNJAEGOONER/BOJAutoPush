class Solution {
    public long solution(long n) {
        long answer = -1;
        if(n % Math.sqrt(n) == 0){
            answer = (long)((Math.sqrt(n) + 1) * (Math.sqrt(n) + 1));
        }
        return answer;
    }
}