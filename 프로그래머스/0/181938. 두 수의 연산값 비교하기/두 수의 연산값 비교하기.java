class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str = Integer.toString(a) + Integer.toString(b);
        int num1 = Integer.parseInt(str);
        
        int num2 = 2 * a * b;
        
        answer = num1 >= num2 ? num1 : num2;
        return answer;
    }
}