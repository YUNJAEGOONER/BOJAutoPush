import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] mmap = new int [n][3];

        for(int i = 0 ; i  < n ; i ++ ){
           String [] RGB = br.readLine().split(" ");
           mmap[i][0] = Integer.parseInt(RGB[0]);
           mmap[i][1] = Integer.parseInt(RGB[1]);
           mmap[i][2] = Integer.parseInt(RGB[2]);
        }

        int answer = Integer.MAX_VALUE;

        for(int k = 0 ; k < 3 ; k ++){
            int [][] dp = new int[n][3];

            dp[1][0] = mmap[0][k] + mmap[1][0];
            dp[1][1] = mmap[0][k] + mmap[1][1];
            dp[1][2] = mmap[0][k] + mmap[1][2];

            dp[1][k] = Integer.MAX_VALUE;

            for(int i = 2 ; i < n - 1; i ++ ){
                dp [i][0] = Math.min(dp[i - 1][1], dp[i -1][2]) + mmap[i][0];
                dp [i][1] = Math.min(dp[i - 1][0], dp[i -1][2]) + mmap[i][1];
                dp [i][2] = Math.min(dp[i - 1][0], dp[i -1][1]) + mmap[i][2];
            }

            dp[n - 1][0] = Math.min(dp[n - 2][1], dp[n -2][2]) + mmap[n - 1][0];
            dp[n - 1][1] = Math.min(dp[n - 2][0], dp[n -2][2]) + mmap[n - 1][1];
            dp[n - 1][2] = Math.min(dp[n - 2][0], dp[n -2][1]) + mmap[n - 1][2];

            dp[n - 1][k] =Integer.MAX_VALUE; // 불가능한 경우

            for(int i = 0 ; i < 3 ; i ++ ){
                if(answer > dp[n - 1][i]){
                    answer = dp[n - 1][i];
                }
            }

        }

        System.out.println(answer);


    }

}
