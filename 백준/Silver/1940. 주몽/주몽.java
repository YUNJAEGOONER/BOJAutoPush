import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        int [] arr = new int [n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0 ; i < n; i++ ){
            int e = Integer.parseInt(stringTokenizer.nextToken());
            arr[i] = e;
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int answer = 0;

        while(start < end){
            if(arr[start] + arr[end] == m){
                answer ++;
                start ++;
                end --;
            }
            else if(arr[start] + arr[end] < m) start ++;
            else end --;
        }

        System.out.println(answer);

    }

}
