import java.util.Arrays;

class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        //1.charArray로 변경
        char [] charArr = my_string.toCharArray();
        
        //charArray -> [ ] 사용이 가능해짐
        //삼항 연산자 condition ? true_value :  false_value
        int idx = ((e - s) % 2 == 0) ? (e - s) / 2 : (e - s) / 2 + 1;
        

        for(int i = s ; i < s + idx ; i ++ ){
            char temp = charArr[i];
            charArr[i] = charArr[e - (i - s)];
            charArr[e - (i - s)] = temp;
        }
        
        //3.charArr를 String으로 변환
        answer = new String(charArr);
        return answer;
    }
}