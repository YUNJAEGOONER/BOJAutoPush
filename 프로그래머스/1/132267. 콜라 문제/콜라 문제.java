class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int change = (n / a) * b;
            n = change + (n % a);
            answer = answer + change;
        }
        return answer;
    }
}