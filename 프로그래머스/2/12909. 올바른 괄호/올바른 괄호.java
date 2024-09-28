class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        char [] my_stack = new char[s.length()];
        int top = -1;
        boolean check = true;
        
        for(int i = 0 ; i < s.length() ; i ++ ){
            //insert : s.length만큼 배열을 확보 -> 넘치는 걱정 x
            if(s.charAt(i) == '('){
                my_stack[++top] = s.charAt(i);
            }
            //delete
            else{
                //stack이 비어있는 경우
                if(top == -1){
                    check = false;
                    break;
                }
                //stack이 비어있지 않는 경우 
                else{
                    if(my_stack[top] == '('){
                        top --;
                    }
                    else{
                        check = false;
                        break;
                    }
                }
            }
        }
        
        if(top == -1 && check){
            answer = true;
        } 
      
        return answer;
    }
}