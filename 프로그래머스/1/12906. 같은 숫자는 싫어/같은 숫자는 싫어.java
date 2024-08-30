import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int cur = -1;
 
        for(int i = 0 ; i < arr.length; i ++ ){
            if (cur != arr[i]){
                cur = arr[i];
                answer.add(arr[i]);
            }
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}