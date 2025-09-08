import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String postFix = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < postFix.length() ; i ++ ){
            char cur = postFix.charAt(i);

            if('A' <= cur && cur <= 'Z'){
                System.out.print(cur); //피연산자는 그대로 출력
            }
            else{
                if(cur == ')'){
                    while (!stack.empty()){
                        if(stack.peek() == '('){
                            break;
                        }
                        System.out.print(stack.pop());
                    }
                    stack.pop(); //'(' 제거
                }
                else{
                    if(stack.empty() || cur == '('){
                        stack.push(cur);
                    }
                    else{
                        if(cur == '+' || cur == '-'){
                            while(!stack.empty()){
                                if(stack.peek() == '('){
                                    break;
                                }
                                System.out.print(stack.pop());
                            }
                        }
                        else if(cur == '*' || cur == '/'){
                            while(!stack.empty()){
                                if(stack.peek() == '*' || stack.peek() == '/'){
                                    System.out.print(stack.pop());
                                }
                                else {
                                    break;
                                }
                            }
                        }
                        stack.push(cur);
                    }
                }
            }
        }

        while (!stack.empty()){
            System.out.print( stack.pop());
        }

    }

}
