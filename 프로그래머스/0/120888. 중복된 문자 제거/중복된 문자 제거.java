class Solution {
    public String solution(String my_string) {
        String answer = "";
        String temp = "";
        for(int i = 0; i < my_string.length() ; i ++ ){
            boolean flag = true;
            for(int j = 0 ; j < temp.length(); j ++ ){
                if(temp.charAt(j) == my_string.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag==true){
                answer = answer + my_string.charAt(i);
                temp = temp + my_string.charAt(i);
            }
        }
        
        return answer;
    }
}