import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int [] no1 = {};
        no1 = new int [answers.length];
        for(int i = 0 ; i < answers.length; i ++ ){
            no1[i] = (i % 5) + 1;
        }
        
        int [] no2 = {};
        no2 = new int [answers.length];
        int [] pattern_2 = {1, 3, 4, 5};
        for(int i = 0 ; i < answers.length; i ++ ){
            if(i % 2 == 0) no2[i] = 2;
            else no2[i] = pattern_2[(i - 1) / 2 % 4]; 
        }
        
        int [] no3 = {};
        no3 = new int [answers.length];
        int [] pattern_3 = {3, 1, 2, 4, 5};
        for(int i =0 ; i < answers.length ; i ++ ){
            no3[i] = pattern_3[i % 10 / 2];
        }
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        int [] scores = {};
        scores = new int [3];
        
        for(int i = 0 ; i < answers.length; i ++ ){
            if(answers[i] == no1[i]) score1++;
            if(answers[i] == no2[i]) score2++;
            if(answers[i] == no3[i]) score3++;
        }
        scores[0] = score1;
        scores[1] = score2;
        scores[2] = score3;
        
        int max = Arrays.stream(scores).max().getAsInt();
        for(int i = 0 ; i < scores.length; i ++ ){
            if(max == scores[i]) answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}