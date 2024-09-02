import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        answer = new int[score.length];
        
        List<Integer> temp_score = new ArrayList<>();
        for(int i = 0 ; i < score.length ; i ++ ){
            temp_score.add(score[i]);
            Collections.sort(temp_score, Collections.reverseOrder());
            if(i <= k - 1)answer[i] = temp_score.get(i);
            else answer[i] = temp_score.get(k - 1);
        }
    
        return answer;
    }
}