import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        answer = new String[strings.length];
        
        Arrays.sort(strings);
        int idx = 0;
        
        for(int i = 0; i < 26; i ++ ){
            for(int j = 0; j < strings.length ; j++ ){
                if(strings[j].charAt(n) - 97 == i) answer[idx ++] = strings[j];
            }
        }

        return answer;
    }
}