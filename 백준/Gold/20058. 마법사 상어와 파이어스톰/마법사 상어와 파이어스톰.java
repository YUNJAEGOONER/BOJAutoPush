import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int [][] arr;
    static boolean [][] visited;

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void rotate(int s){

        int m = (int) Math.pow(2, s);

        int [][] tArr = new int[arr.length][arr.length];
        for(int i = 0 ; i < arr.length ; i ++ ){
            for(int j = 0 ; j < arr.length ; j ++ ){
                int idx = (i / m) * m + j % m;
                int jdx = ((j / m) + 1) * m - ((i % m) + 1);

                tArr[idx][jdx] = arr[i][j];
            }
        }

        for(int i = 0 ; i < arr.length ; i ++ ){
            arr[i] = tArr[i].clone();
        }

    }

    public static void melting(){
        Queue<Pair> mq = new LinkedList<>();
        for(int i = 0 ; i < arr.length ; i ++ ){
            for(int j = 0 ; j < arr.length ;j ++ ){
                int count = 0;
                for(int d = 0 ; d < 4 ; d ++ ){
                    int nx = i + dir_x[d];
                    int ny = j + dir_y[d];
                    if((0 <= nx && nx < arr.length) && (0 <= ny && ny < arr.length)){
                        if(arr[nx][ny] > 0 ){
                            count ++;
                        }
                    }
                }
                if(count <= 2){
                    mq.add(new Pair(i, j));
                }
            }
        }

        while (!mq.isEmpty()){
            Pair cur = mq.poll();
            arr[cur.x][cur.y] --;
        }
    }

    public static int sumArr(){
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i ++ ){
            for(int j = 0 ; j < arr.length ; j ++ ){
                if(arr[i][j] > 0){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static int getWidth(){
        int max = 0;

        for(int i = 0 ; i < arr.length ; i ++ ){
            for(int j = 0 ; j < arr.length ; j ++ ){
                if(arr[i][j] > 0 && !visited[i][j]){
                    int width = 1;
                    Queue<Pair> mq = new LinkedList<>();
                    mq.add(new Pair(i, j));
                    visited[i][j] = true;
                    while (!mq.isEmpty()){
                        Pair cur = mq.poll();
                        int cur_x = cur.x;
                        int cur_y = cur.y;

                        for(int d = 0 ; d < 4 ; d ++ ){
                            int nx = cur_x + dir_x[d];
                            int ny = cur_y + dir_y[d];
                            if((0 <= nx && nx < arr.length) && (0 <= ny && ny < arr.length)){
                                if(arr[nx][ny] > 0 && !visited[nx][ny]){
                                    visited[nx][ny] = true;
                                    width ++ ;
                                    mq.add(new Pair(nx, ny));
                                }
                            }
                        }

                    }
                    max = Math.max(width, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NQ = br.readLine().split(" ");

        int N = Integer.parseInt(NQ[0]); // 상자의 크기 2^N;
        int Q = Integer.parseInt(NQ[1]); // 마법의 수

        int n = (int) Math.pow(2, N);

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0 ; i < n ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++ ){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        String [] cmd = br.readLine().split(" ");
        for(int i = 0 ; i < Q ; i ++){
            rotate(Integer.parseInt(cmd[i]));
            melting();
        }

        int answer1 = sumArr();
        int answer2 = getWidth();

        System.out.println(answer1);
        System.out.println(answer2);


    }

}
