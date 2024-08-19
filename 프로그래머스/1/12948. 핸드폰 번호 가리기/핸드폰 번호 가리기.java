class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int i = 0;
        for(i = 0; i < phone_number.length() - 4; i ++ ){
            answer = answer + "*";
        }
        answer = answer + phone_number.substring(i);
        return answer;
    }
}