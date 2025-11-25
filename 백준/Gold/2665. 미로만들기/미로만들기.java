import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};

    public static class Pair{
        int x;
        int y;
        int c;
        public Pair(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [][] mmap = new int[n][n];

        for(int i = 0 ; i < n ; i ++ ){
            String input = br.readLine();
            for(int j = 0 ; j < input.length() ; j ++){
                mmap[i][j] = input.charAt(j) - '0';
            }
        }

        int [][] visited = new int[n][n];

        Queue<Pair> mq = new LinkedList<>();
        mq.add(new Pair(0, 0, 1));
        visited[0][0] = 1;

        while (!mq.isEmpty()){
            Pair cur = mq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_c = cur.c;
            for(int d = 0 ; d < 4 ; d ++ ){
                int x = cur_x + dir_x[d];
                int y = cur_y + dir_y[d];
                if((0 <= x && x < n) && (0 <= y && y < n)){
                    if(mmap[x][y] == 1){
                        if(visited[x][y] == 0 || visited[x][y] > cur_c){
                            visited[x][y] = cur_c;
                            mq.add(new Pair(x, y, cur_c));
                        }
                    }
                    else{
                        if(visited[x][y] == 0 || visited[x][y] > cur_c + 1){
                            visited[x][y] = cur_c + 1;
                            mq.add(new Pair(x, y, cur_c + 1));
                        }
                    }
                }
            }
        }

        System.out.println(visited[n -1][n - 1] - 1);

    }

}
