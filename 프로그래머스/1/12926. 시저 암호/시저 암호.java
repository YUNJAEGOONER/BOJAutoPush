class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0 ; i < s.length(); i ++ ){
            if('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
                answer = answer + (char)((s.charAt(i) - 97 + n) % 26 + 97); 
            }
            else if('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
               answer = answer + (char)((s.charAt(i) - 65 + n) % 26 + 65);  
            }
            else{
                answer = answer + " ";
            }
        }
        return answer;
    }
}