class Solution {
    public int get_divisor(int num){
        int divisor = 2;
        int result = 1;
        int count = 0;
        
        for(int i = divisor ; i <= num ; i ++ ){
            if(num == 1){
                break;
            }
            while(num % i == 0){
                num = num / i;
                count = count + 1;
            }
            if(count != 0){
                result = result * (count + 1);
                count  = 0;
            }
        }
        return result;
            
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for(int i = 2 ; i <= number ; i ++ ){
            int result = get_divisor(i);
            if(result > limit) answer = answer + power;
            else answer = answer + result;
        }
        return answer;
    }
}