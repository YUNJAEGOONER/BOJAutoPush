import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        char [] arr = new char[len];
        int [] visited = new int[len];

        String str = sc.nextLine();
        for(int i = 0 ; i < str.length() ; i ++ ){
            arr[i] = str.charAt(i);
            if(arr[i] == 'P') visited[i] = 1;
        }

        int answer = 0;

        for(int i = 0 ; i < str.length(); i ++ ){
            if(arr[i] == 'P'){
                int start = i - K;
                int end = i + (K + 1);
                if(start < 0) start = 0;
                if(end > str.length()) end = str.length();
                for(int j = start ; j < end ; j ++ ){
                    if(visited[j] == 0){
                        answer ++;
                        visited[j] = 1;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
