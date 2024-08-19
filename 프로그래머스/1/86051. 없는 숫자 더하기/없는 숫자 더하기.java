class Solution {
    public int solution(int[] numbers) {
        
        int answer = 0;
        int [] flags = new int [10];
        
        for(int i = 0; i < numbers.length; i ++ ){
            flags[numbers[i]] = 1;
        }
        
        for(int i = 0 ; i < flags.length ; i ++ ){
            answer = answer + ((flags[i] == 0) ? i : 0);
        }
        
        return answer;
    }
}