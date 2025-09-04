import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int max = 1;

    public static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[] dir_x = {1, -1, 0, 0};
    static int[] dir_y = {0, 0, 1, -1};

    static int[] visited = new int[26];

    static char[][] mmap;

    public static void dfs(int depth, Pair cur) {
        if (max < depth) {
            max = depth;
        }
        for (int i = 0; i < 4; i++) {
            int x = cur.x + dir_x[i];
            int y = cur.y + dir_y[i];
            if ((0 <= x && x < mmap.length) && (0 <= y && y < mmap[0].length)) {
                if (visited[mmap[x][y] - 'A'] == 0) {
                    visited[mmap[x][y] - 'A'] = 1;
                    dfs(depth + 1, new Pair(cur.x + dir_x[i], cur.y + dir_y[i]));
                    visited[mmap[x][y] - 'A'] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");

        int R = Integer.parseInt(RC[0]);
        int C = Integer.parseInt(RC[1]);

        mmap = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                mmap[i][j] = line.charAt(j);
            }
        }

        visited[mmap[0][0] - 'A'] = 1;
        dfs(1, new Pair(0, 0));
        System.out.println(max);

    }

}
