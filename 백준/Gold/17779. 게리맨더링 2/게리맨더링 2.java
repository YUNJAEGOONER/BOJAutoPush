import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int [][] arr;

    static int [][] temp;

    static int result;

    public static void setEdge(int x, int y, int d1, int d2){
        temp = new int[arr.length][arr.length];

        for(int d = 0 ; d <= d1 ; d ++ ){
            temp[x + d][y - d] = 5;
        }

        for(int d = 0 ; d <= d2 ; d ++ ){
            temp[x + d][y + d] = 5;
        }

        int idx = x + d1;
        int jdx = y - d1;
        for(int d = 0 ; d <= d2 ; d ++ ){
            temp[idx++][jdx++] = 5;
        }

        idx = x + d2;
        jdx = y + d2;
        for(int d = 0 ; d <= d1 ; d ++ ){
            temp[idx++][jdx--] = 5;
        }


        setRegion(x, y, d1, d2);
    }

    public static void setRegion(int x, int y, int d1, int d2){

        // 5번 지역
        for(int i = 0 ; i < temp.length ; i ++ ){
            int sy = -1;
            int ey = -1;

            for(int j = 0 ; j < temp.length ; j ++ ){
                if(temp[i][j] == 5){
                    if(sy == -1){
                        sy = j;
                    }
                    else if(ey == -1){
                        ey = j;
                    }
                }
            }

            if(ey != -1){
                for(int j = sy + 1 ; j < ey ; j ++ ){
                    temp[i][j] = 5;
                }
            }
        }

        //1번지역
        for(int i = 0 ; i < x + d1 ; i ++){
            for(int j = 0 ; j <= y ; j ++){
                if(temp[i][j] == 5){
                    break;
                }
                temp[i][j] = 1;
            }
        }

        for(int i = 0 ; i <= x + d2; i ++ ){
            for(int j = y + 1 ; j < temp.length ; j ++){
                if(temp[i][j] == 0){
                    temp[i][j] = 2;
                }
            }
        }

        //3번지역
        for(int i = x + d1 ; i < temp.length ; i ++){
            for(int j = 0 ; j < y - d1 + d2 ; j ++){
                if(temp[i][j] == 5){
                    break;
                }
                temp[i][j] = 3;
            }
        }

        //4번지역
        for(int i = x + d2 + 1 ; i < temp.length ; i ++){
            for(int j = y - d1 + d2 ; j < temp.length ; j ++){
                if(temp[i][j] == 0){
                    temp[i][j] = 4;
                }
            }
        }
        getAnswer();
    }

    public static void getAnswer(){
        int [] answer = new int[5];

        for(int i = 0 ; i < temp.length ; i ++ ){
            for(int j = 0 ; j < temp.length ; j ++ ){
                answer[temp[i][j] - 1] += arr[i][j];
            }
        }
        Arrays.sort(answer);
        int temp = Math.abs(answer[0] - answer[4]);
        result = Math.min(result, temp);
    }

    public static void printMap(){
        for(int i = 0 ; i < temp.length ; i ++ ){
            for(int j = 0 ; j < temp[0].length ; j ++ ){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = Integer.MAX_VALUE;

        for(int i = 0 ; i < N ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++ ){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < N ; i ++ ){
            for(int j = 0 ; j < N ; j++ ){
                int x = i;
                int y = j;
                for(int d1 = 1; x + d1 + 1 < N ; d1 ++){
                    for(int d2 = 1; y + d2 < N ; d2 ++){
                        if(x + d1 + d2 < N && 0 <= y - d1){
                            setEdge(x, y, d1, d2);
                        }
                    }
                }
            }
        }
        System.out.print(result);


    }
}
