import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int dp [][] = new int [n][n];

        for(int l = 0 ; l < input.length ; l ++ ){
            for(int s = 0; s < input.length - l ; s ++ ){
                //길이가 0
                if(l == 0){
                    dp[s][s + l] = 1;
                }
                else if (l == 1){
                    if(input[s].equals(input[s + l])){
                        dp[s][s + l] = 1;
                    }
                }
                else{
                    if(input[s].equals(input[s + l]) && dp[s + 1][s + l - 1] == 1){
                        dp[s][s + l] = 1;
                    }
                }

            }
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < q ; i ++ ){
            String [] se = br.readLine().split(" ");

            int start = Integer.parseInt(se[0]) - 1;
            int end = Integer.parseInt(se[1]) - 1;
            sb.append(dp[start][end]).append("\n");

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

}
