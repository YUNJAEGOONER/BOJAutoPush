import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][] nums = new int [N][N];

        int [] jdx = new int [N];

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < N ; i ++ ){
            jdx[i] = N - 1;
            for(int j = 0 ; j < N ; j ++ ){
                int element = sc.nextInt();
                nums[i][j] = element;
                if(min > element) min = element;
            }
        }


        int cnt = 0;
        while(true){
            int max = min - 1;
            int idx = 0;
            for(int i = 0 ; i < N ; i ++){
                if(jdx[i] != -1 && max < nums[jdx[i]][i]){
                    max = nums[jdx[i]][i];
                    idx = i;
                }
            }
            jdx[idx] -= 1;
            cnt ++;
            //System.out.println(max);
            if(cnt == N){
                System.out.println(max);
                break;
            }
        }
    }
}
