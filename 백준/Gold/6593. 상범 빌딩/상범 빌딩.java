import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Pair{
        int z;
        int x;
        int y;
        int m;
        public Pair(int z, int x, int y, int m) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.m = m;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){

            String [] LRC = br.readLine().split(" ");

            int L = Integer.parseInt(LRC[0]); //3
            int R = Integer.parseInt(LRC[1]); //4
            int C = Integer.parseInt(LRC[2]); //5

            if(L == 0 && R == 0 && C == 0){
                break;
            }

            char [][][] buildings = new char[L][R][C];
            boolean [][][] visited = new boolean[L][R][C];

            Queue<Pair> mq = new LinkedList<>();

            int tz = 0;
            int tx = 0;
            int ty = 0;

            for(int i = 0 ; i < L ; i ++ ){
                for(int j = 0 ; j < R ; j ++ ){
                    String str = br.readLine();
                    for(int k = 0 ; k < C ; k ++ ){
                        buildings[i][j][k] = str.charAt(k);
                        if(str.charAt(k) == 'S'){
                            mq.add(new Pair(i, j, k,0));
                            visited[i][j][k] = true;
                        }
                        else if(str.charAt(k) == 'E'){
                            tz = i;
                            tx = j;
                            ty = k;
                        }
                    }
                }
                br.readLine();
            }

            int [] dir_x = {1, -1, 0, 0};
            int [] dir_y = {0, 0, 1, -1};

            while (!mq.isEmpty()){
                Pair prev = mq.poll();

                int cur_x = prev.x;
                int cur_y = prev.y;
                int cur_z = prev.z;
                int cur_m = prev.m;

                if(cur_x == tx && cur_y == ty && cur_z == tz){
                    System.out.printf("Escaped in %d minute(s).\n", cur_m);
                    break;
                }

                for(int i = 0 ; i < 4 ; i ++ ){
                    int x = cur_x + dir_x[i];
                    int y = cur_y + dir_y[i];
                    if((0 <= x && x < R) && (0 <= y && y < C)){
                        if(buildings[cur_z][x][y] != '#' && !visited[cur_z][x][y]){
                            visited[cur_z][x][y] = true;
                            mq.add(new Pair(cur_z, x, y,cur_m + 1));
                        }
                    }
                }

                //하
                if(cur_z - 1 >= 0 && buildings[cur_z - 1][cur_x][cur_y] != '#' && !visited[cur_z - 1][cur_x][cur_y]){
                    visited[cur_z - 1][cur_x][cur_y] = true;
                    mq.add(new Pair(cur_z - 1, cur_x, cur_y,cur_m + 1));
                }

                //상
                if(cur_z + 1 < L && buildings[cur_z + 1][cur_x][cur_y] != '#' && !visited[cur_z + 1][cur_x][cur_y]){
                    visited[cur_z + 1][cur_x][cur_y] = true;
                    mq.add(new Pair(cur_z + 1, cur_x, cur_y,cur_m + 1));
                }

            }

            if(!visited[tz][tx][ty]){
                System.out.println("Trapped!");
            }

        }


    }

}
