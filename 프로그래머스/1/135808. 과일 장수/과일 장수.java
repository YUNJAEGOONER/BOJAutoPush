import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for(int i = score.length - m ; i > -1 ; i = i - m){
            //System.out.println(score[i]);
            answer = answer + m * score[i]; 
        }
        return answer;
    }
}