class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int len = arr.length;
        int cnt = 0;
        
        
        while(len > 1){
            if(len % 2 == 1) len = len + 1;
            len = len / 2;
            cnt ++;
        }
        
        double arrsize = Math.pow(2, cnt);
        
        answer = new int[(int)arrsize];
        
        for(int i = 0 ; i < arr.length ; i ++ ){
            answer[i] = arr[i];
        }
        
        return answer;
    }
}