import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String my_string) {
        List<String> answer = new ArrayList<>();
        String element = "";
        for(int i = 0 ; i < my_string.length() ; i ++ ){
            if(element != "" && my_string.charAt(i) == ' '){
                answer.add(element);
                element = "";
            }
            else element = element + my_string.charAt(i);
        }
        if(element != "") answer.add(element);
        return answer.stream().toArray(String[]::new);
    }
}