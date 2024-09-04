import java.util.Arrays;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int idx1 = -1;
        int idx2 = -1;
 
        for(int i = 0 ; i < goal.length ; i ++ ){
            if(Arrays.asList(cards1).indexOf(goal[i]) != -1){
                if(Arrays.asList(cards1).indexOf(goal[i]) - idx1 == 1){
                    idx1 = Arrays.asList(cards1).indexOf(goal[i]);
                }
                else{
                    break;
                }
            }
            else if(Arrays.asList(cards2).indexOf(goal[i]) != -1){
                if(Arrays.asList(cards2).indexOf(goal[i]) - idx2 == 1){
                    idx2 = Arrays.asList(cards2).indexOf(goal[i]);
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
            if(i == goal.length - 1) answer = "Yes";
        }
        return answer;
    }
}