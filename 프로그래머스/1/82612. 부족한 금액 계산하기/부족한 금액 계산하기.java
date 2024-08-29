class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long need = 0;
        for(int i = 0 ; i < count ; i ++ ){
            need = need + (long)(price * (i + 1));
        }
        answer = (need > (long)money) ? need - (long)money : 0;
        return answer;
    }
}