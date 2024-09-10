class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String convert = "";
        for(int i = 0 ; i < myString.length() ; i ++ ){
            if(myString.charAt(i) == 'A') convert = convert + 'B';
            else convert = convert + 'A';
        }
        if(convert.contains(pat))answer = 1;
        return answer;
    }
}