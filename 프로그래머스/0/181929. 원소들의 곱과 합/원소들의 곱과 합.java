class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sqr = 0;
        int mul = 1;
        for(int i = 0 ; i < num_list.length ; i ++ ){
            sqr = sqr + num_list[i];
            mul = mul * num_list[i];
        }
        answer = (Math.pow(sqr,2) > mul) ? 1 : 0;
        return answer;
    }
}