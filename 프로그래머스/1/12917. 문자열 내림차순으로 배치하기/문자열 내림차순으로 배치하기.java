import java.util.Arrays;
import java.lang.StringBuilder;

class Solution {
    public String solution(String s) {
        String answer = "";
        char [] charArr = s.toCharArray();
        Arrays.sort(charArr);
        answer = new StringBuilder(new String(charArr)).reverse().toString();
        return answer;
    }
}