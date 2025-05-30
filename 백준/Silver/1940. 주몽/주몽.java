import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int [n];
        for(int i = 0 ; i < n; i++ ){
            int e = sc.nextInt();
            arr[i] = e;
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int answer = 0;

        while(start < end){
            if(arr[start] + arr[end] == m) answer ++;

            if(arr[start] + arr[end] < m) start ++;
            else end --;
        }

        System.out.println(answer);

    }

}
