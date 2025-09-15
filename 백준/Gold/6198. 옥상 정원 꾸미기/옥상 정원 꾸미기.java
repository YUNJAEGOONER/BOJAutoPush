import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < N ; i ++ ){
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }

        stack.add(arr[0]);

        long answer = 0;

        for(int i = 1 ; i < N ; i ++ ){
            if(stack.peek() > arr[i]){
                answer += stack.size();
                stack.add(arr[i]);
            }
            else{
                while(true){
                    if(stack.empty()){
                        break;
                    }
                    else if(stack.peek() <= arr[i]){
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
                answer += stack.size();
                stack.add(arr[i]);
            }
        }
        System.out.println(answer);
    }

}
