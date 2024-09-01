class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int count = 0;
        
        if(my_string.length() >= is_suffix.length()){
            int start = my_string.length() - is_suffix.length();
            for(int i = start; i < my_string.length(); i ++ ){
                if(my_string.charAt(i) == is_suffix.charAt(i - start))count++;
            }
        }
        
        if(count == is_suffix.length())answer = 1;
        return answer;
    }
}