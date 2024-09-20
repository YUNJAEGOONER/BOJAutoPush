import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String myString) {
        List<Integer> answer = new ArrayList<>();
        int element = 0;
        for(int i = 0 ; i < myString.length() ; i++ ){
            if(myString.charAt(i) == 'x'){
                answer.add(element);
                element = 0;
            }
            else element++;
        }
        answer.add(element);
        return answer.stream().mapToInt(x->x).toArray();
    }
}