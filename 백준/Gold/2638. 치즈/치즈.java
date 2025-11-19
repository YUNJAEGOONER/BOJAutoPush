import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};

    static int [][] mmap;

    static int N;

    static int M;

    static int cnt;

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(Queue<Pair> mq){

        int [][] visited = new int[N][M];

        while (!mq.isEmpty()){
            Pair cur = mq.poll();
            for(int i = 0 ; i < 4 ; i ++ ){
                int x = cur.x + dir_x[i];
                int y = cur.y + dir_y[i];
                if((0 <= x && x < N) && (0 <= y && y < M)){
                    if(visited[x][y] == 0 && (mmap[x][y] == 0 || mmap[x][y] == -1)){
                        visited[x][y] = 1;
                        if(mmap[x][y] == 0){
                            cnt ++;
                        }
                        mmap[x][y] = -1;
                        mq.add(new Pair(x, y));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        mmap = new int[N][M];

        for(int i = 0 ; i < N ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j  < M ; j ++ ){
                mmap[i][j] = Integer.parseInt(input[j]);
            }
        }

        //bfs를 수행
        Queue<Pair> mq = new LinkedList<>();
        mq.add(new Pair(0, 0));
        bfs(mq);

        int day = 0;
        while(cnt != (N * M)){
            day ++;
            for(int i = 0 ; i < N ; i ++ ){
                for(int j = 0 ; j < M ; j ++ ){
                    int air = 0;
                    if(mmap[i][j] == 1){
                        for(int k = 0 ; k < 4 ; k ++ ){
                            if(mmap[i + dir_x[k]][j + dir_y[k]] == -1){
                                air ++;
                            }
                        }
                        if(air >= 2){
                            mmap[i][j] = 0;
                        }
                    }
                }
            }
            mq.add(new Pair(0, 0));
            bfs(mq);
        }

        System.out.println(day);


    }

}
