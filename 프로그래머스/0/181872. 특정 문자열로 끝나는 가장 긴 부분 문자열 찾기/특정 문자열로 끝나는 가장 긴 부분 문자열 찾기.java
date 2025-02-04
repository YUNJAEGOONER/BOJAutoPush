class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        
        int end = 0;
        
        for(int i = myString.length() - 1 ; i > - 1 ; i -- ){
            int cnt = 0;
            int idx = 0;
            for(int j = pat.length() - 1 ; j > - 1 ; j -- ){
                if(pat.charAt(j) == myString.charAt(i - idx)){               
                    cnt = cnt + 1;
                }
                else{
                    break;
                }
                idx ++;
            }
            if(cnt == pat.length()){
                end = i; 
                break;
            }

        }
            
      
        System.out.println(end);
        
        for(int i = 0 ; i < end + 1 ; i ++ ){
            answer = answer + myString.charAt(i);
        }
        return answer;
    }
}