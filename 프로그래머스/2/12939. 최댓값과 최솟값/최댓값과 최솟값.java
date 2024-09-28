import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        List<Integer> nums = new ArrayList<>();
        
        String temp = "";
        for(int i = 0 ; i < s.length() ; i ++ ){
            if(s.charAt(i) == ' '){
                int num = Integer.parseInt(temp);
                nums.add(num);
                temp = "";
            }
            else{
                temp = temp + s.charAt(i);
            }
        }
        nums.add(Integer.parseInt(temp));
        
        answer = Integer.toString(Collections.min(nums)) + 
            ' ' + Integer.toString(Collections.max(nums));
        
        return answer;
    }
}