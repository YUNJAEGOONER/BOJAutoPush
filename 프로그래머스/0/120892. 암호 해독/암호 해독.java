class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int i = 1;
        while(true){
            if((i * code - 1) >= cipher.length()) break;
            answer = answer + cipher.charAt(i * code - 1);
            i ++;
        }
        return answer;
    }
}