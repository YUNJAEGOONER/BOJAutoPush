class Solution {
    public int solution(int num) {
        int answer = -1;
        int count = 0;
        
        long lnum = (long)num;
        while(++count <= 500){
            if(lnum % 2 == 0){
                lnum = lnum / 2;
            }
            else{
                if(lnum == 1){
                    answer = 0;
                    break;
                }
                lnum = (lnum * 3) + 1;
            }
            if(lnum == 1){
                answer = count;
                break;
            }
        }
        return answer;
    }
}