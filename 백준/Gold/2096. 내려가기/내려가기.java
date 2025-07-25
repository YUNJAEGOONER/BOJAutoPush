import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] min = new int [n][3];
        int [][] max = new int [n][3];


        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < 3 ; j ++ ){
                int num = sc.nextInt();
                min[i][j] = num;
                max[i][j] = num;
            }
        }


        for(int i = 1 ; i < n ; i ++ ){
            min[i][0] = min[i][0] + Integer.min(min[i - 1][0], min[i -1][1]);
            min[i][1] = min[i][1] + Integer.min(min[i - 1][0], Integer.min(min[i - 1][1], min[i - 1][2]));
            min[i][2] = min[i][2] + Integer.min(min[i - 1][1], min[i - 1][2]);
        }

        for(int i = 1 ; i < n ; i ++ ){
            max[i][0] = max[i][0] + Integer.max(max[i - 1][0], max[i -1][1]);
            max[i][1] = max[i][1] + Integer.max(max[i - 1][0], Integer.max(max[i - 1][1], max[i - 1][2]));
            max[i][2] = max[i][2] + Integer.max(max[i - 1][1], max[i - 1][2]);
        }


        int minval = Integer.min(min[n - 1][0], Integer.min(min[n-1][1], min[n-1][2]));
        int maxval = Integer.max(max[n - 1][0], Integer.max(max[n-1][1], max[n-1][2]));

        System.out.println(maxval + " " + minval);

    }
}
