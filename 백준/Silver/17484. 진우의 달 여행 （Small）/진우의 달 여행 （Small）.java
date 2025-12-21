import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] MN = br.readLine().split(" ");

        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        int [][] mmap = new int[M][N];

        for(int i = 0 ; i < M ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++ ){
                mmap[i][j] = Integer.parseInt(input[j]);
            }
        }

        int [][][] dp = new int [M][N][3];

        for(int j = 0 ; j < N ; j ++ ){
            for(int d = 0 ; d < 3 ; d ++ ){
                dp[0][j][d] = mmap[0][j];
            }
        }

        //[0] 좌측에서 온거
        //[1] 가운데에서 온거
        //[2] 우측에서 온거

        for(int i = 1; i < M ; i++ ){
            for(int j = 0 ; j < N ; j ++){
                if(j == 0){
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + mmap[i][j];
                    dp[i][j][0] = Integer.MAX_VALUE;
                }
                else if(j == N - 1){
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + mmap[i][j];
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
                else{
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + mmap[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + mmap[i][j];
                }
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + mmap[i][j];
            }

        }

        int min = Integer.MAX_VALUE;
        for(int j = 0 ; j < N ; j ++){
            for(int d = 0 ; d < 3 ; d ++ ){
                if(min > dp[M - 1][j][d]){
                    min = dp[M - 1][j][d];
                }
            }
        }
        System.out.println(min);


    }


}
