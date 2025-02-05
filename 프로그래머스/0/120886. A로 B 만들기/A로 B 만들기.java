import java.util.HashMap;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        HashMap<Character, Integer> bmap = new HashMap<>();
        
        for(int i = 0 ; i < before.length() ; i ++ ){
            char key = before.charAt(i);
            if(bmap.containsKey(before.charAt(i))){
                int temp = bmap.get(key);
                bmap.put(key, temp + 1);
            }
            else{
                bmap.put(key, 1);
            }
        }
        
        HashMap<Character, Integer> amap = new HashMap<>();
        
        for(int i = 0 ; i < after.length() ; i ++ ){
            char key = after.charAt(i);
            if(amap.containsKey(after.charAt(i))){
                int temp = amap.get(key);
                amap.put(key, temp + 1);
            }
            else{
                amap.put(key, 1);
            }
        }
        
        for(Character k : bmap.keySet()){
            if(bmap.get(k) != amap.get(k)){
                answer = 0;
                break;
            }
        }
        
        
        return answer;
    }
}