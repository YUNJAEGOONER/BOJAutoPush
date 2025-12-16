import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] MN = br.readLine().split(" ");

        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        char [][] mmap = new char[M][N];

        for(int i = 0 ; i < M ; i ++ ) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                mmap[i][j] = input.charAt(j);
            }
        }

        int max = 0;

        for(int i = 0 ; i < M ; i ++ ){
            for(int j = 0 ; j < N ; j ++ ){
                int [][] visited = new int[M][N];
                Queue<Pair> mq = new LinkedList<>();
                if(mmap[i][j] == 'L'){
                    visited[i][j] = 1;
                    mq.add(new Pair(i, j));
                    while (!mq.isEmpty()){
                        Pair pair = mq.poll();
                        int x = pair.x;
                        int y = pair.y;
                        for(int d = 0 ; d < 4 ; d ++ ){
                            int nx = x + dir_x[d];
                            int ny = y + dir_y[d];
                            if((0 <= nx && nx < M ) && (0 <= ny && ny < N)
                                    && visited[nx][ny] == 0 && mmap[nx][ny] == 'L'){
                                mq.add(new Pair(nx, ny));
                                visited[nx][ny] = visited[x][y] + 1;
                                if(max < visited[nx][ny]){
                                    max = visited[nx][ny] - 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);


    }

}
