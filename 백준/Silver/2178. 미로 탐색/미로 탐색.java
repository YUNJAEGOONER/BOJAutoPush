import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] map = new int [n][m];

        for(int i = 0 ; i < n ; i ++ ){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0 ; j < line.length() ; j ++ ){
                map[i][j] = (line.charAt(j) - '0');
            }
        }

        boolean [][] visit = new boolean[n][m];

        //최단거리 -> BFS
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        map[0][0] = 0;

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int distance = map[cur_x][cur_y];
            visit[cur_x][cur_y] = true;
            //상-하-좌-우
            for(int i = 0 ; i < 4; i ++ ){
                int x = cur_x + dx[i];
                int y = cur_y + dy[i];
                if(0 <= x && x < n && 0 <= y && y < m && !visit[x][y] && map[x][y] == 1){
                    queue.add(new Point(x, y));
                    map[x][y] = distance + 1;
                }
            }
        }

        System.out.println(map[n - 1][m - 1] + 1);

    }
}
