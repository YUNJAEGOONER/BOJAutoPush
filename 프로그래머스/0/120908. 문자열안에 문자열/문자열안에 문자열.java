class Solution {
    public int solution(String str1, String str2) {
        // if(str1.indexOf(str2) != -1){
        //     return 1;
        // }
        // return 2;(
        int answer = 2;
        for(int i = 0 ; i < str1.length() - str2.length() + 1; i ++){
            int count = 0;
            for(int j = 0 ; j < str2.length(); j ++ ){
                if(str1.charAt(i + j) == str2.charAt(j))count++;
            }
            if(count == str2.length())answer=1;
        }
        return answer;
    }
        
}