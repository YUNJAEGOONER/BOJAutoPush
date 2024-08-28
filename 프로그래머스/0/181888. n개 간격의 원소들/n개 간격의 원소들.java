import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while(idx <= num_list.length - 1){
            answer.add(num_list[idx]);
            idx = idx + n;
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}