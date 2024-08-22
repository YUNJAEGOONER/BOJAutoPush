class Solution {
    public int get_gcd(int num1, int num2){
        //step1.최대공약수 구하기 -> gcd (a,b) = gcd (b, a % b);
        int a = num1;
        int b = num2;
        
        while(true){
            if(b == 0 || b == 1){
                if(b == 1) a = 1;
                break;
            }
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        answer = new int[2];
        
        int numer = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;
        
        int gcd = get_gcd(numer, denom);
        answer[0] = numer/gcd;
        answer[1] = denom/gcd;

        return answer;
    }
}