class Solution {
    public long solution(long n) {
        String answer = "";
        
        int [] digit = new int [10];
        String num = Long.toString(n);
        for(int i = 0; i < num.length() ; i ++ ){
            digit[num.charAt(i) - '0']++;
        }
        
        for(int i = 9; i > -1 ; i -- ){
            for(int j = 0 ; j < digit[i]; j ++ ){
                answer = answer + i;
            }
        }
        
        return Long.parseLong(answer);
    }
}