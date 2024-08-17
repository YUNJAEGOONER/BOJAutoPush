class Solution {
    
    public int Even_Odd(int num){
        return num % 2;
    }
    
    public String solution(int num) {
        String answer = "";
        int result = Even_Odd(num);
        if(result == 0) answer = "Even";
        else answer = "Odd";
        return answer;
    }
}