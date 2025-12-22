import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());
        int n = (int) Math.sqrt(N) + 1;

        int dp [] = new int[(int)N + 1];

        for(int i = 0 ; i <= n ; i ++ ){
            int pow = (int) Math.pow(i, 2);
            if(pow <= N){
                dp[pow] = 1;
            }
        }

        for(int i  = 1 ; i < (int) N + 1 ; i ++ ){
            if(dp[i] == 0){
                int min = Integer.MAX_VALUE;
                int end = (int) Math.sqrt(i);
                for(int j = 1 ; j < end + 1; j ++ ){
                    if(i - j * j >= 0){
                        int temp = 1+ dp[i - j * j];
                        if(min > temp){
                            min = temp;
                        }
                    }
                }
                dp[i] = min;
            }
        }
        System.out.println(dp[(int) N]);

    }


}
