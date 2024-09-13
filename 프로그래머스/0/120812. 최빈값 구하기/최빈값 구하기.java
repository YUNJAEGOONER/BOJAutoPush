import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < array.length ; i ++ ){
            int key = array[i];
            if(map.containsKey(key))map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        
        int max = Collections.max(map.values());
        int count = 0;
        for(int key : map.keySet()){
            if(max == map.get(key)){
                if(count == 0) answer = key;
                else answer = -1;
                count ++;
            }
        }
        return answer;
    }
}