class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        myString = myString.toLowerCase();
        if(myString.contains(pat.toLowerCase())) answer = 1;
        return answer;
    }
}