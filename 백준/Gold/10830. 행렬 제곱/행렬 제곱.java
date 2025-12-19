import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int [][] matrix;

    public static int [][] matrix_multiplay(int [][] a, int [][] b){

        int [][] result = new int[a.length][a.length];

        for(int k = 0 ; k < a.length ; k ++){
            for(int i = 0 ; i < a.length ; i ++ ){
                int temp = 0;
                for(int j = 0 ; j < b.length ; j ++ ){
                    int x = (a[k][j] % 1000);
                    int y = (b[j][i] % 1000);
                    temp += ((x * y) % 1000) % 1000;
                }
                result[k][i] = temp % 1000;
            }
        }

        return result;
    }

    public static int[][] get_square(long n){
        if(n == 1){
            return matrix;
        }
        
        int [][] half = get_square(n / 2);

        if(n % 2 == 0){
            return matrix_multiplay(half, half);
        }
        else{
            return matrix_multiplay(half, matrix_multiplay(half, matrix));
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NB = br.readLine().split(" ");

        int N = Integer.parseInt(NB[0]);
        long B = Long.parseLong(NB[1]);

        matrix = new int[N][N];

        for(int i = 0 ; i < N ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j  < input.length ; j ++ ){
                matrix[i][j] = Integer.parseInt(input[j]) % 1000;
            }
        }

        int [][] result = get_square(B);

        for(int i = 0 ; i < result.length ; i ++ ){
            for(int j = 0 ; j < result.length ; j ++ ){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
