class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() == 6){
            answer = true;
            for(int i = 0 ; i < s.length() ; i ++ ){
                if('0' > s.charAt(i) || s.charAt(i) > '9'){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}