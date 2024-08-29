class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() == 6){
            int count = 0;
            for(int i = 0 ; i < s.length() ; i ++ ){
                if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                    count++;
                }
            }
            answer = (count == s.length()) ? true : false;
        }
        return answer;
    }
}