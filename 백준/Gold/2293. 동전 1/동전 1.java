import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] nk = br.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int [][] dp = new int[k + 1][n];

        int [] coins = new int[n];
        for(int i = 0 ; i < n ; i ++ ){
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }
        Arrays.sort(coins);

        //k = 10
        for(int i = 0 ; i < k + 1 ; i ++ ){
            //n = 3
            for(int j = 0 ; j < n ; j ++ ){
                int prev = i - coins[j];
                if(prev == 0){
                    dp[i][j] = 1;
                }
                else if(prev > 0){
                    int sum = 0;
                    for(int s = 0 ; s <= j ; s ++ ){
                        sum += dp[prev][s];
                    }
                    dp[i][j] = sum;
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < n ; i ++ ){
            answer += dp[k][i];
        }

        System.out.println(answer);



    }

}
