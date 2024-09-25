import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int [N];
        
        //각 stage에 있는 플레이어의 수를 세기 위함
        int [] users = new int [N + 1];
        for(int i = 0; i < stages.length; i ++ ){
            users[stages[i] - 1]++;
        }
        
        //스테이지 번호를 key로 실패율을 value로 하는 map
        HashMap<Integer, Float> map = new HashMap<>();
        
        //실패율 계산
        //2번 stage 실패율 = #stages = 2 플레이어 수 / #stage >= 2 플레이어 수
        int sum = 0;
        for(int i = 0 ; i < users.length - 1 ; i ++ ){
            //분모가 0이 되는 경우 
            if(stages.length - sum == 0){
                map.put(i + 1, (float)0);
            }
            else{
                map.put(i + 1, (float)users[i] / (float)(stages.length - sum));
            }
            //계산하고자 하는 stage의 이전 플레이어들의 수를 세기 위함
            sum = sum + users[i];
        }
        
        //value를 기준으로 key를 내림차순 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((k1, k2)->map.get(k2).compareTo(map.get(k1)));
        
        //오름차순 정렬 방법
        //keySet.sort((k1, k2)->map.get(k1).compareTo(map.get(k1)));
        
        answer = keySet.stream().mapToInt(x->x).toArray();
        return answer;
    }
}