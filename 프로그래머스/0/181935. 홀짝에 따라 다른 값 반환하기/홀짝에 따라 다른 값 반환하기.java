class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int i = (n % 2 == 0) ? 0 : 1;
        int mul = (n % 2 == 0) ? 2 : 1;
        
        for(i = i ; i <= n ; i = i + 2 ){
            answer = answer + (int)Math.pow(i, mul);
        }
        return answer;
    }
}