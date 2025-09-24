import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int [][] mmap;
    static int s_s = 2;

    public static int getDistance(int s_x, int s_y, int t_x, int t_y){

        int min = Integer.MAX_VALUE;

        int [][] visited = new int[mmap.length][mmap.length];
        for(int i = 0 ; i < visited.length ; i ++ ){
            visited[i] = mmap[i].clone();
        }

        int [] dir_x = {1, -1, 0 , 0};
        int [] dir_y = {0, 0, 1, -1};

        Queue<Pair> mq = new LinkedList<>();
        mq.add(new Pair(s_x, s_y, 0));
        visited[s_x][s_y] = -1;

        while (!mq.isEmpty()){
            Pair cur = mq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_t = cur.t;

            if(cur_x == t_x && cur_y == t_y){
                min = cur_t;
                break;
            }

            for(int i = 0 ; i < 4 ; i ++ ){
                int x = cur_x + dir_x[i];
                int y = cur_y + dir_y[i];
                if((0 <= x && x < mmap.length) && (0 <= y && y < mmap.length)) {
                    if (visited[x][y] != -1 && visited[x][y] <= s_s) {
                        mq.add(new Pair(x, y, cur_t + 1));
                        visited[x][y] = -1; //방문 표시
                    }
                }
            }
        }

        return min;
    }

    public static class Pair{
        int x;
        int y;
        int t;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mmap = new int[n][n];

        List<Pair> fishes = new ArrayList<>();

        //상어의 위치와 상어의 크기
        int s_x = 0;
        int s_y = 0;

        for(int i = 0 ; i < n ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++ ){
                mmap[i][j] = Integer.parseInt(input[j]);
                if(mmap[i][j] != 9 && mmap[i][j] != 0){
                    fishes.add(new Pair(i, j));
                }
                else if (mmap[i][j] == 9){
                    s_x = i;
                    s_y = j;
                    mmap[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int ate = 0;

        while (true){

            if(ate == s_s){
                s_s ++;
                ate = 0;
            }

            int target_idx = -1;
            int target_x = -1;
            int target_y = -1;
            int min = Integer.MAX_VALUE;

            for(int i = 0 ; i < fishes.size() ; i ++ ){
                int f_x = fishes.get(i).x;
                int f_y = fishes.get(i).y;
                //상어가 먹을 수 있는 생선인지,,,(본인보다 작은 생선을 먹을 수 있다.)
                if(s_s > mmap[f_x][f_y]){
                    int dis = getDistance(s_x, s_y, f_x, f_y);
                    if(min > dis){
                        min = dis;
                        target_x = f_x;
                        target_y = f_y;
                        target_idx = i;
                    }
                    else if(min != Integer.MAX_VALUE && min == dis){
                        if(target_x > f_x){
                            target_x = f_x;
                            target_y = f_y;
                            target_idx = i;
                        }
                        else if(target_x == f_x && target_y > f_y){
                            target_x = f_x;
                            target_y = f_y;
                            target_idx = i;
                        }
                    }
                }

            }

            if(target_idx == -1){
                break;
            }
            else{
                answer += min;
                ate++;
                s_x = target_x;
                s_y = target_y;
                fishes.remove(target_idx);
                //System.out.println("s_x : " + s_x + "s_y : " + s_y + " dis :" + min + " s_s : " + s_s);
            }


        }

        System.out.println(answer);
    }

}
