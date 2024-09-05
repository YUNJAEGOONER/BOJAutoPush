import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
    
        for(int i = 0 ; i < delete_list.length ; i ++ ){
            for(int j = 0 ; j < arr.length ; j ++ ){
                if(delete_list[i] == arr[j]){
                    arr[j] = 0;
                }
            }
        }
        
        for(int i = 0 ; i < arr.length ; i ++ ){
            if(arr[i] != 0) answer.add(arr[i]);
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}