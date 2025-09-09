import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");

        int m = Integer.parseInt(MN[0]);
        int n = Integer.parseInt(MN[1]);

        int[][] mmap = new int[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                mmap[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Pair> mq = new LinkedList<>();
        int[][][] distance = new int[m][n][2];

        mq.add(new Pair(0, 0));
        distance[0][0][0] = 1;

        int[] dir_x = {1, -1, 0, 0};
        int[] dir_y = {0, 0, 1, -1};

        while (!mq.isEmpty()) {

            Pair cur = mq.poll();

            int cur_x = cur.x;
            int cur_y = cur.y;

            for (int i = 0; i < 4; i++) {

                int x = cur_x + dir_x[i];
                int y = cur_y + dir_y[i];

                if ((0 <= x && x < m) && (0 <= y && y < n)) {
                    boolean search = false;

                    int min = Integer.MAX_VALUE;

                    if (mmap[x][y] == 0) { // 지금 안부숴도 됨 (안부순거 update, 부순거 update하고)

                        if (distance[cur_x][cur_y][0] != 0 && distance[x][y][0] == 0) {
                            distance[x][y][0] = distance[cur_x][cur_y][0] + 1;
                            search = true;
                        }

                        if (distance[cur_x][cur_y][1] != 0 && distance[x][y][1] == 0) {
                            distance[x][y][1] = distance[cur_x][cur_y][1] + 1;
                            search = true;
                        }

                    } else { //지금 부숴야함 (이전에 부순상태면 x)
                        if (distance[cur_x][cur_y][0] != 0) {
                            if (distance[x][y][1] == 0 || distance[x][y][1] > distance[cur_x][cur_y][0] + 1) {
                                distance[x][y][1] = distance[cur_x][cur_y][0] + 1;
                                search = true;
                            }
                        }
                    }

                    if (search) {
                        mq.add(new Pair(x, y));
                    }

                }
            }
        }

        int a = distance[m - 1][n - 1][0];
        int b = distance[m - 1][n - 1][1];
        int result = -1;

        if(a == 0 && b == 0){
            result = -1;
        }
        else if (a == 0 || b == 0){
            result = a < b ? b : a;
        }
        else{
            result = a < b ? a : b;
        }

        System.out.println(result);
    }

}