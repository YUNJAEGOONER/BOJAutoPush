import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String my_string) {
        List<String>answer = new ArrayList<>();
        String word = "";
        for(int i = 0 ; i < my_string.length() ; i ++ ){
            if(my_string.charAt(i) == ' ' && word != ""){
                answer.add(word);
                word = "";
            }
            else if (my_string.charAt(i) != ' '){
                word = word + my_string.charAt(i);
            }
        }
        if(word != "") answer.add(word);
        return answer.stream().toArray(String[]::new);
    }
}