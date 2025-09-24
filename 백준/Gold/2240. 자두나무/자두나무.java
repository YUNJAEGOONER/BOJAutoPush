import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static class State{
        int t;
        int x;
        int m;
        public State(int t, int x, int m){
            this.t = t;
            this.x = x;
            this.m = m;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] TW = br.readLine().split(" ");

        int T = Integer.parseInt(TW[0]);
        int W = Integer.parseInt(TW[1]);

        //시간/현재위치/이동횟수
        int [][][] dp = new int[T][2][W + 1];

        for(int i = 0 ; i < T ; i ++ ){
            for(int j = 0 ; j < 2 ; j ++ ){
                for(int k = 0 ; k < W ; k ++ ){
                    dp[i][j][k] = -1;
                }
            }
        }

        int [] arr = new int[T];

        for(int i = 0 ; i < T ; i ++){
            int e = Integer.parseInt(br.readLine());
            arr[i] = e;
        }

        if(arr[0] == 1){
            dp[0][0][0] = 1;
        }
        else{
            dp[0][0][0] = 0;
            dp[0][1][1] = 1;
        }

        int max = 1;

        for(int i = 1; i < T ; i ++){
            int cur_jadu = arr[i] - 1; // 자두 위치
            for(int j = 0 ; j < 2; j ++){
                for(int k = 0 ; k < W + 1 ; k ++ ){
                    if(dp[i - 1][j][k] != - 1){
                        //움직이지 않는 경우
                        if(j == cur_jadu && dp[i][j][k] < dp[i - 1][j][k] + 1){
                            dp[i][j][k] = dp[i - 1][j][k] + 1;
                            if(dp[i][j][k] > max) max = dp[i][j][k];
                        }
                        else{
                            if(dp[i][j][k] < dp[i - 1][j][k]) {
                                dp[i][j][k] = dp[i - 1][j][k];
                            }
                        }

                        //움직이는 경우
                        if(k + 1 <= W){
                            int cur = j;
                            if(cur == 0) { //1 이었으면
                                cur = 1;
                            }
                            else {
                                cur = 0;
                            }
                            if(cur_jadu == cur && dp[i][cur][k + 1] < dp[i - 1][j][k] + 1){
                                dp[i][cur][k + 1] = dp[i - 1][j][k] + 1;
                                if(max < dp[i - 1][j][k] + 1) max = dp[i - 1][j][k] + 1;
                            }
                            else{
                                if(dp[i][cur][k + 1] < dp[i - 1][j][k] + 1) {
                                    dp[i][cur][k + 1] = dp[i - 1][j][k];
                                }
                            }
                        }

                    }
                }
            }

        }

        System.out.println(max);
    }
}
