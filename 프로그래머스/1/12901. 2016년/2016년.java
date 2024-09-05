class Solution {
    String [] tag = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int [] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String solution(int a, int b) {
        String answer = "";
        int sum = 5; //Friday
        for(int i = 0 ; i < a - 1 ; i ++ ){
            sum = sum + days[i];
        }
        sum = sum + b - 1;
        answer = tag[sum % 7];
        return answer;
    }
}