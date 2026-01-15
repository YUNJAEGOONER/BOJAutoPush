import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int [] dir_x = {-1, 0, 1, 0};
    static int [] dir_y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NKR = br.readLine().split(" ");

        int N = Integer.parseInt(NKR[0]);
        int K = Integer.parseInt(NKR[1]);
        int R = Integer.parseInt(NKR[2]);

        boolean [][][] roadMap = new boolean[N][N][4]; // 상 우 하 좌

        //도로 R개
        for(int i = 0 ; i < R ; i ++ ){
            String road [] = br.readLine().split(" ");

            int r1 = Integer.parseInt(road[0]) - 1;
            int c1 = Integer.parseInt(road[1]) - 1;

            int r2 = Integer.parseInt(road[2]) - 1;
            int c2 = Integer.parseInt(road[3]) - 1;

            //상하로 길이 있는 경우
            if(Math.abs(r1 - r2) == 1){
                if(r1 > r2){
                    roadMap[r2][c2][2] = true;
                    roadMap[r1][c1][0] = true;
                }
                else{
                    roadMap[r1][c1][2] = true;
                    roadMap[r2][c2][0] = true;
                }
            }
            //좌우로 길이 있는 경우
            else{
                if(c1 > c2){
                    roadMap[r2][c2][1] = true;
                    roadMap[r1][c1][3] = true;
                }
                else{
                    roadMap[r2][c2][3] = true;
                    roadMap[r1][c1][1] = true;
                }
            }
        }

        //k개 만큼
        //소의 위치
        List<Pair> cowList = new ArrayList<>();

        for(int k = 0 ; k < K ; k ++ ){
            String cow [] = br.readLine().split(" ");
            int x = Integer.parseInt(cow[0]) - 1;
            int y = Integer.parseInt(cow[1]) - 1;
            cowList.add(new Pair(x, y));
        }

        int answer = (cowList.size() * (cowList.size() - 1)) / 2;

        for(int i = 0 ; i < cowList.size() ; i ++ ){
            Pair start = cowList.get(i);
            int start_x = start.x;
            int start_y = start.y;

            for(int j = i + 1 ; j < cowList.size() ; j ++ ){
                Pair target = cowList.get(j);
                int target_x = target.x;
                int target_y = target.y;

                boolean [][] visited = new boolean[N][N];
                Queue<Pair> mq = new LinkedList<>();
                mq.add(new Pair(start_x, start_y));
                visited[start_x][start_y] = true;

                while (!mq.isEmpty()){
                    Pair cur = mq.poll();
                    int cur_x = cur.x;
                    int cur_y = cur.y;

                    if(cur_x == target_x && cur_y == target_y){
                        break;
                    }

                    for(int d = 0 ; d < 4 ; d ++ ){
                        int nx = cur_x + dir_x[d];
                        int ny = cur_y + dir_y[d];
                        //범위안에 들어가고
                        if((0 <= nx && nx < N) && (0 <= ny && ny < N)){
                            if(!visited[nx][ny] && !roadMap[cur_x][cur_y][d]){ // 길을 건너지 않으면
                                visited[nx][ny] = true;
                                mq.add(new Pair(nx, ny));
                            }
                        }
                    }

                }

                if(visited[target_x][target_y]){
                    answer --;
                }
            }
        }


        System.out.println(answer);



    }

}
