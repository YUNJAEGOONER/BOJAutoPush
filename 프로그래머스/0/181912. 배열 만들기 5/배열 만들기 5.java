import java.util.ArrayList;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i = 0 ; i < intStrs.length ; i ++ ){
            String temp = intStrs[i].substring(s, s + l);
            Integer toInt = Integer.valueOf(temp);
            if(toInt > k){
                arrList.add(toInt);
            }
        }
        
        answer = arrList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}