import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        //String을 모두 소문자로 바꾸고, 문자열을 char배열로 바꾸어준다.
        char [] charstr = my_string.toLowerCase().toCharArray();
        
        //정렬을 수행한다.
        Arrays.sort(charstr);
        
        //정렬이 끝난 문자열 배열을 다시 String으로 변환하고 반환한다.
        answer = new String(charstr);
        return answer;
    }
}