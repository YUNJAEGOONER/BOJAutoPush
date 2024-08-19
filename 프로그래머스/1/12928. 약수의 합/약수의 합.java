class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= (int)Math.sqrt(n) ; i ++ ){
            if(n % i == 0){
                answer = answer + i + (n / i);
                //제곱근의 경우 16 -> 1, 2, 4, 8, 16
                if(i == (n / i)){
                    answer = answer - i;
                }
            }
        }
        return answer;
    }
}