class Solution {
    int [] visit = {};
    int [] elements = {};
    int answer = 0;
    
    public void check_prime(){
        int num = 0;
        for(int i = 0 ; i < visit.length ; i ++ ){
            if(visit[i] == 1) num = num + elements[i];
        }
        
        boolean check = true;
        for(int i = 2; i <= Math.sqrt(num); i ++ ){
            if(num % i == 0){
                check = false;
                break;
            }
        }
        if(check) answer ++;
    }
    
    public void combi(int start, int count){
        if(count == 3){
            check_prime();
            return;
        }
        else{
            for(int i = start ; i < visit.length; i ++ ){
                if(visit[i] == 1) continue;
                visit[i] = 1;
                combi(i , count + 1);
                visit[i] = 0;
            }
        }
    }
    
    public int solution(int[] nums) {
        visit = new int [nums.length];
        elements = nums;
        combi(0, 0);
        return answer;
    }
}