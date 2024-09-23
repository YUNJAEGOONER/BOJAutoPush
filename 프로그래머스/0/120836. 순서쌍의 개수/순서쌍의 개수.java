class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1 ; i <= Math.sqrt(n); i ++ ){
            if(n % i == 0) answer = answer + 1;
        }
        answer = answer * 2;
        if(Math.pow((int)(Math.sqrt(n)), 2) == n) answer = answer - 1;
        return answer;
    }
}