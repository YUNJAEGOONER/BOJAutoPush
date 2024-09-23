class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i = 1 ; i < numLog.length; i ++ ){
            int result = numLog[i] - numLog[i - 1];
            switch(result){
                case 1 : 
                    answer = answer + 'w';
                    break;
                case -1 :
                    answer = answer + 's';
                    break;
                case 10 :
                    answer = answer + 'd';
                    break;
                case -10 : 
                    answer = answer + 'a';
                    break;
            }
        }
        return answer;
    }
}