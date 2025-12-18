import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] DN = br.readLine().split(" ");
        int D = Integer.parseInt(DN[0]);
        int N = Integer.parseInt(DN[1]);

        int [] arr = new int[D];
        String [] input = br.readLine().split(" ");

        int [] min_oven = new int[input.length];
        int min = -1;

        for(int i = 0 ; i < D ; i ++ ){
            arr[i] = Integer.parseInt(input[i]); // 5 6 4 3 ...
            if(min == -1){
                min = arr[i];
            }
            else if(min > arr[i]){
                min = arr[i];
            }
            min_oven[i] = min;
        }

        String [] sp = br.readLine().split(" ");

        int [] pizza = new int[sp.length];

        for(int i = 0 ; i < sp.length ; i ++ ){
            pizza[i] = Integer.parseInt(sp[i]);
        }

        int cnt = 0;

        int start_jdx = D - 1;

        for(int i = 0 ; i < N ; i ++ ){
            int cur = pizza[i];
            for(int j = start_jdx ; j > -1 ; j --) {
                if (cur <= arr[j] && min_oven[j] >= cur) {
                    start_jdx = j - 1;
                    cnt++;
                    break;
                }
            }
        }

        if(cnt == N){
            System.out.print(start_jdx + 2);
        }
        else{
            System.out.print(0);
        }

    }

}
