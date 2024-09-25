import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int [N];
        
        int [] users = new int [N + 1];
        for(int i = 0; i < stages.length; i ++ ){
            users[stages[i] - 1]++;
        }
        
        HashMap<Integer, Float> map = new HashMap<>();
        
        int sum = 0;
        for(int i = 0 ; i < users.length - 1 ; i ++ ){
            if(stages.length - sum == 0){
                map.put(i + 1, (float)0);
            }
            else{
                map.put(i + 1, (float)users[i] / (float)(stages.length - sum));
            }
            sum = sum + users[i];
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((k1, k2)->map.get(k2).compareTo(map.get(k1)));
        
        answer = keySet.stream().mapToInt(x->x).toArray();
        return answer;
    }
}