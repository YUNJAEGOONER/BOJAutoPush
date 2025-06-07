import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] arr = new int [N];
        for(int i = 0 ; i < N ; i ++ ){
            int e = sc.nextInt();
            arr[i] = e;
        }

        int [][] dp = new int [N + 1][2];
        dp[1][0] = arr[0]; dp[1][1] = arr[0];

        for(int i = 2 ; i < N + 1 ; i ++ ){
            if(dp[i - 2][1] > dp[i - 2][0]){
                dp[i][1] = dp[i - 2][1] + arr[i - 1];
            }
            else{
                dp[i][1] = dp[i - 2][0] + arr[i - 1];
            }
            dp[i][0] = dp[i-1][1] + arr[i - 1];
        }
        
        int ans = dp[N][0] > dp[N][1] ? dp[N][0] : dp[N][1];
        System.out.println(ans);
    }
}
