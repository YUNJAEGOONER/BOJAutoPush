import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i ++ ){
            for(int j = 0 ; j < arr[i] ; j ++ ){
                answer.add(arr[i]);
            }
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
}