import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String postFix = br.readLine();

        double [] toNum = new double[26];

        for(int i = 0 ; i < N ; i ++ ){
            double value = Double.parseDouble(br.readLine());
            toNum[i] = value;
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0 ; i < postFix.length() ; i ++ ){

            char cur = postFix.charAt(i);

            if('A' <= cur && cur <= 'Z'){
                stack.add(toNum[cur - 'A']);
            }
            else{
                double b = stack.pop();
                double a = stack.pop();

                if(cur == '+'){
                    stack.add(a + b);
                }
                else if(cur == '-'){
                    stack.add(a - b);
                }
                else if(cur == '*'){
                    stack.add(a * b);
                }
                else if(cur == '/'){
                    stack.add(a / b);
                }
            }
        }

        System.out.printf("%.2f", stack.peek());

    }
}
