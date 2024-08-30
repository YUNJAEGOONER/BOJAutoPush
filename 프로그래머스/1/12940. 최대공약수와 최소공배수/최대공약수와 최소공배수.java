class Solution {
    
    public int[] get_gcd(int a, int b){
        int [] result = new int [2];
        
        int num1 = a;
        int num2 = b;
        
        while(true){
            int temp = a;
            a = b;
            b = temp % b;
            if(b == 0 || b == 1) break;
        }
        
        if(b == 0){
            result[0] = a;
        }
        else{
            result[0] = b;
        }
        result[1] = (num1 * num2) / result[0];
        return result;
        
    }
    
    public int[] solution(int n, int m) {
        int[] answer = {};
        answer = (n > m) ? get_gcd(n, m) : get_gcd(m , n);
        return answer;
    }
}