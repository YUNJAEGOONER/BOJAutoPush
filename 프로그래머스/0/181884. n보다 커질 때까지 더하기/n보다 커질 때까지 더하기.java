class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        int idx = 0;
         
        while(true){
            if(answer > n){
                break;
            }
            answer = answer + numbers[idx++]; 
        }
        return answer;
    }
}