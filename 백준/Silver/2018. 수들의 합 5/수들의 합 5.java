import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        int start = 0;
        int end = 0;

        int cnt = 0;

        long current_sum = 0;

        while(end <= n){
            if(current_sum < n){
                end ++;
                current_sum += end;
            }
            else{
                start ++;
                current_sum -= start;
            }
            if(current_sum == n) cnt ++;
        }
        System.out.println(cnt);
    }
}
