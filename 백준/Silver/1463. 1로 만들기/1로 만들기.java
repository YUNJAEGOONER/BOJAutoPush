import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        int [] dp = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur % 3 == 0 && (dp[cur/3] == 0 || dp[cur/3] > dp[cur/3] + 1)){
                dp[cur/3] = dp[cur] + 1;
                queue.add(cur/3);
            }
            if(cur % 2 == 0 && (dp[cur/2] == 0 || dp[cur/2] > dp[cur/2] + 1)){
                dp[cur/2] = dp[cur] + 1;
                queue.add(cur/2);
            }
            if(cur - 1 >= 0 && (dp[cur - 1] == 0 || dp[cur-1] > dp[cur-1] + 1)){
                dp[cur-1] = dp[cur] + 1;
                queue.add(cur-1);
            }
        }
        System.out.println(dp[1]);
        
    }
}
