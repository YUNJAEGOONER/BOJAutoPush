import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String [] str = br.readLine().split(" ");

        int [] inputs = new int[n];

        for(int i = 0 ; i < n ; i ++ ){
            inputs[i] = Integer.parseInt(str[i]);
        }

        int [] increase = new int[n];
        increase[0] = 1;

        for(int i = 1; i < n ; i ++ ){
            int max = 1;
            for(int j = 0 ; j < i ; j ++){
                if(inputs[j] < inputs[i] && increase[j] >= max){
                    max = increase[j] + 1;
                }
            }
            increase[i] = max;
        }

        int [] decrease = new int[n];
        decrease[n - 1] = 1;

        for(int i = n - 1; i > -1 ; i -- ){
            int max = 1;
            for(int j = n - 1 ; j > i ; j --){
                if(inputs[j] < inputs[i] && decrease[j] >= max){
                    max = decrease[j] + 1;
                }
            }
            decrease[i] = max;
        }


        for(int i = 0 ; i < increase.length ; i ++ ){
            increase[i] += (decrease[i] - 1);
        }

        int answer = 0;
        for(int i = 0 ; i < increase.length ; i ++ ){
            if(answer < increase[i]){
                answer = increase[i];
            }
        }
        System.out.println(answer);

    }

}
