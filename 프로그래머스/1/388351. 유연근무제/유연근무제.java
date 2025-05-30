import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        Set<Integer> mset = new HashSet<>();
        
        for(int i = 0 ; i < schedules.length ; i ++ ){
            int temp = schedules[i];
            temp += 10;
            if(temp % 100 >= 60){
                temp += 100;
                temp -= 60;
            }
            schedules[i] = temp;
        }
        
        for(int i = 0 ; i < schedules.length ; i ++ ){
            System.out.print(schedules[i] + " ");
        }
        
        startday -= 1;
        for(int i = 0 ; i < timelogs[0].length ; i ++ ){
            int day = (startday + i) % 7 + 1;
            if(day != 6 && day != 7){
                for(int j = 0 ; j < timelogs.length; j ++ ){
                    if(timelogs[j][i] > schedules[j]){
                        mset.add(j);
                    }
                }
            }
        }
        
        answer = timelogs.length - mset.size();
        
        return answer;
    }
}