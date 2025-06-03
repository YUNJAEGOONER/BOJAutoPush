import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int r = 0 ; r < n ; r ++ ){
            st = new StringTokenizer(br.readLine());

            System.out.print(Integer.parseInt(st.nextToken()));

            int [] arr = new int[20];
            for(int i = 0 ; i < 20 ; i ++ ){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900 919

            int cnt = 0;

            for(int i = 1 ; i < 20; i ++ ){
                for(int j = 0 ; j <= i ; j ++ ){
                    if(arr[i] < arr[j]){
                        int temp = arr[i];
                        for(int k = i ; k > j ; k -- ){
                            arr[k] = arr[k - 1];
                            cnt ++;
                        }
                        arr[j] = temp;
                        i --;
                        break;
                    }
                }


            }

            System.out.println(" " + cnt);

        }
    }
}
