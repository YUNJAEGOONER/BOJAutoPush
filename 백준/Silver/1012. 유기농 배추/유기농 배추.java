import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        for (int test = 0; test < p; test++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int r = sc.nextInt();

            int[][] mmap = new int[m][n];

            for (int i = 0; i < r; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                mmap[a][b] = 1;
            }

            Queue<Pair> queue = new LinkedList<>();

            int[] dir_x = {1, -1, 0, 0};
            int[] dir_y = {0, 0, 1, -1};

            int answer = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mmap[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        answer++;
                        while (!queue.isEmpty()) {
                            Pair cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int x = cur.x + dir_x[k];
                                int y = cur.y + dir_y[k];
                                if ((0 <= x && x < m) && (0 <= y && y < n)) {
                                    if (mmap[x][y] == 1) {
                                        mmap[x][y] = 0;
                                        queue.add(new Pair(x, y));
                                    }
                                }
                            }

                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
