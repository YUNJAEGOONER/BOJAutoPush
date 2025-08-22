import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] nums = new int[n];

        for(int i = 0 ; i < n ; i ++ ){
            int e = sc.nextInt();
            nums[i] = e;
        }

        int lis = 0;
        int [] dp = new int[n];
        for(int i = 0 ; i < n ; i ++ ){
            dp[i] = 1;
            for(int j = 0 ; j < i ; j ++){
                if(nums[j] < nums[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > lis){
                lis = dp[i];
            }
        }

        System.out.println(n - lis);

    }
}
