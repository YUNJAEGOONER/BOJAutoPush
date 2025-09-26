import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int [][] visited; //시간 - 이전 위치
    static Queue<Pair> mq;

    public static void visit(int x, int y, int prev){
        if(0 > x || x >= 100_001){
            return;
        }
        if(visited[x][0] == -1 || visited[x][0] > y){
            visited[x][0] = y; // 시간
            visited[x][1] = prev; // 이전 위치
            mq.add(new Pair(x, y));
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK [] = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        visited = new int[100_001][2];
        for(int i = 0 ; i < 100_001 ; i ++ ){
            Arrays.fill(visited[i], -1);
        }

        mq = new LinkedList<>();
        Pair pair = new Pair(N, 0);
        mq.add(pair);
        visited[N][0] = 0;
        visited[N][1] = -1;


        while (true){
            Pair cur = mq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            if(cur_x == K){
                System.out.println(visited[cur_x][0]);

                List<Integer> arr = new ArrayList<>();
                int now = cur_x;
                int prev = visited[cur_x][1];
                arr.add(now);

                while(true){
                    if(now == N){
                        break;
                    }
                    arr.add(prev);
                    now = prev;
                    prev = visited[now][1];
                }

                for(int i = arr.size() - 1; i > - 1 ; i -- ){
                    System.out.print(arr.get(i) + " ");
                }
                break;
            }
            visit(cur_x + 1, cur_y + 1, cur_x);
            visit(cur_x - 1, cur_y + 1, cur_x);
            visit(cur_x * 2, cur_y + 1, cur_x);
        }

    }

}
