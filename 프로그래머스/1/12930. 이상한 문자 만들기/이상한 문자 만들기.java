class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        
        s = s.toLowerCase();
        for(int i = 0 ; i < s.length(); i ++ ){
            if(s.charAt(i) == ' '){
                answer = answer + ' ';
                idx = -1;
            }
            else if((idx % 2) == 0){
                answer = answer + (char)(s.charAt(i) - 32);
            }
            else{
                answer = answer + (char)(s.charAt(i));
            }
            idx++;
        }
        return answer;
    }
}