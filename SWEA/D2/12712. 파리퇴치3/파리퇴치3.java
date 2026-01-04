import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int [] dir1_x = {-1, 0, 1, 0};
    static int [] dir1_y = {0, 1, 0, -1};

    static int [] dir2_x = {1, -1, -1, 1};
    static int [] dir2_y = {1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test ; t ++ ){
            String [] MN = br.readLine().split(" ");
            int N = Integer.parseInt(MN[0]);
            int M = Integer.parseInt(MN[1]); //세기

            int answer = -1;

            int [][] arr = new int[N][N]; // 파리의 개체 수

            for(int i = 0 ; i < N ; i ++ ){
                String [] input = br.readLine().split(" ");
                for(int j = 0 ; j < N ; j ++ ){
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            for(int i = 0 ; i < N ; i ++ ){
                for(int j = 0 ; j < N ; j ++ ){
                    //십자가 모양
                    int sum = arr[i][j];
                    for(int d = 0 ; d < 4 ; d ++ ){
                        int idx = i;
                        int jdx = j;
                        for(int k = 0 ; k < M - 1 ; k ++){
                            idx += dir1_x[d];
                            jdx += dir1_y[d];
                            if((0 <= idx && idx < N) && (0 <= jdx && jdx < N)){
                                sum += arr[idx][jdx];
                            }
                        }
                    }
                    if(answer < sum){
                        answer = sum;
                    }

                    //x자 모양
                    sum = arr[i][j];
                    for(int d = 0 ; d < 4 ; d ++ ){
                        int idx = i;
                        int jdx = j;
                        for(int k = 0 ; k < M - 1 ; k ++){
                            idx += dir2_x[d];
                            jdx += dir2_y[d];
                            if((0 <= idx && idx < N) && (0 <= jdx && jdx < N)){
                                sum += arr[idx][jdx];
                            }
                        }
                    }

                    if(answer < sum){
                        answer = sum;
                    }

                }
            }
            System.out.println(String.format("#%d %d", t + 1, answer));
        }
        
    }
}
