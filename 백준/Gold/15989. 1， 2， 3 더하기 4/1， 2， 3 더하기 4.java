import java.util.Scanner;

public class Main {

    static int [][] dp = new int[10_001][4];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        dp[1][1] = 1; dp[1][2] = 0; dp[1][3] = 0;
        dp[2][1] = 1; dp[2][2] = 1; dp[2][3] = 0;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        while((T --) > 0){
            int n = sc.nextInt();
            if(n <= 3 || dp[n][1] != 0){
                System.out.println(getAnswer(n));
            }
            else{
                count(n);
                System.out.println(getAnswer(n));
            }
        }
    }

    public static int getAnswer(int n){
        return dp[n][1] + dp[n][2] + dp[n][3];
    }

    public static void count(int n){
        if(dp[n][1] != 0){
            return;
        }
        count(n - 1);
        dp[n][1] = dp[n - 1][1];
        dp[n][2] = dp[n - 2][1] + dp[n - 2][2];
        dp[n][3] = dp[n - 3][1] + dp[n - 3][2] + dp[n - 3][3];
    }

}
