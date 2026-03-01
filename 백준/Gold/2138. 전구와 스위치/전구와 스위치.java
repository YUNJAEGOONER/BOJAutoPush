import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char arr [];
    static char brr [];
    static String a;
    static String b;
    static int answer, n;

    public static void init(){
        for(int i = 0 ; i < n ; i ++ ){
            arr[i] = a.charAt(i);
            brr[i] = b.charAt(i);
        }
    }

    public static void zero(){
        arr[0] = arr[0] == '0' ? '1' : '0';
        arr[1] = arr[1] == '0' ? '1' : '0';
    }

    public static int check(boolean zero){
        int cnt = 0;
        if(zero) cnt = 1;
        
        for(int i = 0 ; i < n - 1 ; i ++ ){
            if(arr[i] != brr[i]){
                arr[i] = brr[i];
                if(i + 1 < n) arr[i + 1] = arr[i + 1] == '0' ? '1' : '0';
                if(i + 2 < n) arr[i + 2] = arr[i + 2] == '0' ? '1' : '0';
                cnt ++;
            }
        }

        if(arr[n - 1] == brr[n - 1]) return cnt;
        return n + 1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = br.readLine();
        b = br.readLine();

        arr = new char[n];
        brr = new char[n];

        init();
        int nz = check(false);
        
        init();
        zero();
        int yz = check(true);

        answer = Math.min(nz, yz);

        if(answer == n + 1) answer = -1;
        System.out.print(answer);

    }
}
