import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int [] visited;
    static List<Character> operators;
    static List<Integer> operands;

    static String input;

    static int max;

    public static void bt(int start){

        List<Character> toperators = new ArrayList<>(operators);
        List<Integer> toperands = new ArrayList<>(operands);

        for(int j = 0 ; j < visited.length ; j ++ ){
            if(visited[j] == 1){
                char op = toperators.get(j);
                int op1 = toperands.get(j);
                int op2 = toperands.get(j + 1);

                int result = 0;
                if(op == '+') result = op1 + op2;
                else if(op == '-') result = op1 - op2;
                else if(op == '*') result = op1 * op2;

                toperands.remove(j);
                toperands.remove(j);
                toperands.add(j, 0);
                toperands.add(j, result);

                toperators.remove(j);
                toperators.add(j,'+');
            }
        }

        int temp = toperands.get(0);
        for(int i = 0 ; i < toperators.size() ; i ++){
            char op = toperators.get(i);
            int op1 = toperands.get(i + 1);

            if(op == '+') temp += op1;
            else if(op == '-') temp -= op1;
            else if(op == '*') temp *= op1;
        }

        if(temp > max) max = temp;

        if(start >= visited.length){
            return;
        }

        for(int i = start ; i < visited.length ; i ++){
            if(visited[i] == 0){
                visited[i] = 1;
                bt(i + 2);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        input = br.readLine();

        int [] opidx = new int[input.length()/2];

        operators = new ArrayList<>();
        operands = new ArrayList<>();

        int idx = 0;
        for(int i = 0 ; i < input.length() ; i ++ ){
            if('0' <= input.charAt(i) && input.charAt(i) <= '9'){
                operands.add(input.charAt(i) - '0');
            }
            else{
                operators.add(input.charAt(i));
            }
        }

        visited = new int[opidx.length];

        max = operands.get(0);
        for(int i = 0 ; i < operators.size() ; i ++){
            char op = operators.get(i);
            int op1 = operands.get(i + 1);

            if(op == '+') max += op1;
            else if(op == '-') max -= op1;
            else if(op == '*') max *= op1;
        }
        
        bt(0);
        System.out.println(max);

    }

}
