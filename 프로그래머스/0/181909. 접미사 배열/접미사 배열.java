import java.util.Arrays;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        answer = new String[my_string.length()];
        
        String suffix = "";
        for(int i = my_string.length() - 1 ; i > -1  ; i -- ){
            suffix = my_string.charAt(i) + suffix;
            answer[my_string.length() - 1 - i] = suffix;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}