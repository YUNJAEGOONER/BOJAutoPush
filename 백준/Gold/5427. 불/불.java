import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Pair{
        int x;
        int y;
        int time;
        public Pair(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int question = Integer.parseInt(br.readLine());

        for(int i = 0 ; i  < question ; i ++){

            String [] NM = br.readLine().split(" ");

            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            char [][] mmap = new char[M][N];

            Queue<Pair> fires = new LinkedList<>();

            int [][] times = new int [M][N];

            Queue<Pair> run = new LinkedList<>();


            int [][] visited = new int[M][N];

            for(int j = 0 ; j  < M ; j ++ ){
                String input = br.readLine();
                for(int k = 0 ; k < input.length() ; k ++ ){
                    mmap[j][k] = input.charAt(k);
                    if(mmap[j][k] == '*'){
                        fires.add(new Pair(j, k, 0));
                        times[j][k] = -1;
                    }
                    else if(mmap[j][k] == '@'){
                        run.add(new Pair(j, k, 0));
                        visited[j][k] = 1;
                    }
                }
            }


            int [] dir_x = {1, -1, 0, 0};
            int [] dir_y = {0, 0, 1, -1};

            while(!fires.isEmpty()){
                Pair cur = fires.poll();
                int cur_x = cur.x;
                int cur_y = cur.y;
                int time = cur.time;
                for(int j = 0 ; j < 4 ;  j ++ ){
                    int x = cur_x + dir_x[j];
                    int y = cur_y + dir_y[j];
                    int t = time + 1;
                    if((0 <= x && x < M) && (0 <= y && y < N)){
                        if(mmap[x][y] != '#' && (times[x][y] == 0 || times[x][y] > t)){
                            times[x][y] = t;
                            fires.add(new Pair(x, y, t));
                        }
                    }
                }
            }

            int min = (N * M) + 1;

            while (!run.isEmpty()){
                Pair cur = run.poll();
                int cur_x = cur.x;
                int cur_y = cur.y;
                int time = cur.time;

                for(int j = 0 ; j < 4 ; j ++ ){
                    int x = cur_x + dir_x[j];
                    int y = cur_y + dir_y[j];
                    int t = time + 1;
                    if((x < 0 || x >= M) || (y < 0 || y >= N)){
                        if(min > t){
                            min = t;
                        }
                    }
                    else {
                        if(visited[x][y] == 0 && (mmap[x][y] != '#' && (times[x][y] > t || times[x][y] == 0))){ // 불 보다 빨리 움직인 경우에는 해당 칸에 방문 가능
                            run.add(new Pair(x, y, t));
                            visited[x][y] = 1;
                        }
                    }
                }

            }

            if(min == N * M + 1){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(min);
            }
        }

    }

}
