import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static int disabled [];

    public static int available(int n){
        if(n >= 0){
            String temp = Integer.toString(n);
            int cnt = 500001;
            for(int i = 0 ; i < temp.length() ; i ++){
                if(disabled[temp.charAt(i) - '0'] == 1){
                    return cnt;
                }
            }
            return temp.length();
        }
        return 500001;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer target = Integer.parseInt(br.readLine()); //target

        int M = Integer.parseInt(br.readLine());

        disabled = new int[10];

        if(M > 0) {
            String[] ms = br.readLine().split(" ");
            for (int i = 0; i < ms.length; i++) {
                int num = Integer.parseInt(ms[i]);
                disabled[num] = 1;
            }
        }

        // +/- 만을 통해 이동
        int answer = Math.abs(target - 100);


        for(int i = 0 ; i < answer ; i ++ ){
            // +
            int plus = target + i;
            answer = Math.min(available(plus) + i, answer);
            // -
            int minus = target - i;
            answer = Math.min(available(minus) + i, answer);
        }

        System.out.println(answer);

    }
}
