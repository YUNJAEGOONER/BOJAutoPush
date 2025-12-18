import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i ++ ){
            String [] se = br.readLine().split(" ");

            int start = Integer.parseInt(se[0]);
            int end = Integer.parseInt(se[1]);

            int interval = end - start;

            int dis = 1;
            int cnt = 0;

            while(interval > 0){
                if(interval - 2 * dis >= 0){
                    interval -= 2 * dis;
                    cnt += 2;
                    dis ++;
                    //System.out.println("interval = " + interval);
                }
                else {
                    interval -= dis;
                    cnt ++;
                }
            }

            System.out.println(cnt);
        }


    }

}
