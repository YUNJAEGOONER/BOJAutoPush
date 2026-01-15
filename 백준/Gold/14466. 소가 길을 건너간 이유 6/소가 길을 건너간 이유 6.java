import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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

        int [][] mmap = new int [N][N];

        int answer = 0;

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

        //k개 만큼의 소의 위치
        for(int k = 0 ; k < K ; k ++ ){
            String cow [] = br.readLine().split(" ");
            int x = Integer.parseInt(cow[0]) - 1;
            int y = Integer.parseInt(cow[1]) - 1;
            mmap[x][y] = 1;
        }


        boolean [][] visited = new boolean[N][N];

        HashMap<Integer, Integer> cowMap = new HashMap<>();

        int group = 0;

        //make region group
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++ ){
                int cow = 0;
                if(!visited[i][j]){
                    Queue<Pair> mq = new LinkedList<>();
                    mq.add(new Pair(i, j));
                    if(mmap[i][j] == 1){
                        cow ++;
                    }
                    visited[i][j] = true;
                    while (!mq.isEmpty()){
                        Pair cur = mq.poll();
                        int cur_x = cur.x;
                        int cur_y = cur.y;
                        for(int d = 0 ; d < 4 ; d ++ ){
                            int nx = cur_x + dir_x[d];
                            int ny = cur_y + dir_y[d];
                            //범위안에 들어가고
                            if((0 <= nx && nx < N) && (0 <= ny && ny < N)){
                                if(!visited[nx][ny] && !roadMap[cur_x][cur_y][d]){ // 길을 건너지 않으면
                                    visited[nx][ny] = true;
                                    mq.add(new Pair(nx, ny));
                                    if(mmap[nx][ny] == 1){
                                        cow += 1;
                                    }
                                }
                            }
                        }
                    }
                    cowMap.put(group ++, cow);
                }
            }
        }


        List<Integer> cows = new ArrayList<>();
        for(int c : cowMap.keySet()){
            cows.add(cowMap.get(c));
        }

        for(int i = 0 ; i < cows.size() ; i ++ ){
            for(int j = i + 1 ; j < cows.size() ; j ++ ){
                answer += cows.get(i) * cows.get(j);
            }
        }

        System.out.println(answer);

    }

}
