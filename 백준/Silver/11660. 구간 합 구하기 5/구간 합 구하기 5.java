import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, M;
        N = in.nextInt();
        M = in.nextInt();

        int[][] arr = new int[N][N + 1];

        int sum;
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 1; j < N + 1; j++) {
                int e;
                e = in.nextInt();
                sum += e;
                arr[i][j] = sum;
            }
        }

        while(M-- > 0){
            int x1, y1, x2, y2;
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();

            int result = 0;
            for(int i = x1 - 1; i < x2; i++){
                result += arr[i][y2] - arr[i][y1 - 1];
            }
            System.out.println(result);
        }

    }
}