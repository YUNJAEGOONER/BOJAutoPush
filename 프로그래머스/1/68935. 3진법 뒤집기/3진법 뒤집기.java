import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> nums = new ArrayList<>();
        while(n > 2){
            int temp = n % 3;
            nums.add(temp);
            n = (n - temp) / 3;
        }
        nums.add(n);
        
        // for(int i = 0 ; i < nums.size() ; i ++ ){
        //     System.out.println(nums.get(i));
        // }
        
        int mul = 1;
        for(int i = nums.size() - 1 ; i > -1; i -- ){
            answer = answer + (mul * nums.get(i));
            mul = mul * 3;
        }
        
        return answer;
    }
}