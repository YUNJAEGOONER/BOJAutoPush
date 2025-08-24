import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int [] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n ; i ++ ){
            int temp_max = 1;
            for(int j = i - 1 ; j > -1 ; j --){
                if(arr[i] < arr[j]){
                    if(temp_max <= dp[j]){
                        temp_max = dp[j] + 1;
                    }
                }

            }
            dp[i] = temp_max;
        }
        
        int answer = 0;
        for(int i = 0 ; i < n ; i ++ ){
            if(answer < dp[i]){
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}
