import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        int [][] arrA = new int [n][m];
        int [][] arrB = new int [n][m];

        for (int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < m ; j ++ ){
                int e = sc.nextInt();
                arrA[i][j] = e;
            }
        }

        for (int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < m ; j ++ ){
                int e = sc.nextInt();
                arrB[i][j] = e;
            }
        }

        for (int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < m ; j ++ ){
                System.out.print(arrA[i][j] + arrB[i][j] + " ");
            }
            System.out.println();
        }
    }
}
