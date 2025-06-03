import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] arr = new int [N];
        for(int i = 0 ; i < N ; i ++){
            int element = sc.nextInt();
            arr[i] = element;
        }

        int [] visit = new int [N];

        for(int i = 0 ; i < N ; i ++ ){
            int cnt = 0;
            for(int j = 0 ; j < N; j ++ ){
                if(visit[j] == 0){
                    cnt ++;
                }
                if(cnt == arr[i] + 1){
                    visit[j] = i + 1;
                    break;
                }
            }

        }

        for(int a : visit){
            System.out.print(a + " ");
        }
    }
}
