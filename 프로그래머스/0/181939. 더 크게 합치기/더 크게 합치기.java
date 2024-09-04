class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String str1 = Integer.toString(a) + Integer.toString(b);
        int num1 = Integer.parseInt(str1);
        
        String str2 = Integer.toString(b) + Integer.toString(a);
        int num2 = Integer.parseInt(str2);
        
        answer = num1 >= num2 ? num1 : num2;
        return answer;
    }
}