class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n);
        for(int i = 0 ; i < str.length() ; i ++ ){
            answer = answer + (str.charAt(i) - '0');
        }
        return answer;
    }
}