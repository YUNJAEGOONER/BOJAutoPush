class Solution {
    public int get_divisor(int num){
        int result = 1;
        int temp = num;
        
        for(int i = 2; i <= temp ; i ++ ){
            int count = 0;
            while(temp % i == 0){
                temp = temp / i;
                count++;
            }
            result = result * (count + 1);
        } 
        return result;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left ; i <= right ; i ++ ){
            if(get_divisor(i) % 2 == 0) answer = answer + i;
            else answer = answer - i;
        }
        return answer;
    }
}