import java.util.ArrayList;
import java.util.List;
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

    static int[] dir_x = {1, -1, 0, 0};
    static int[] dir_y = {0, 0, 1, -1};

    static int max = -1;

    static int[][] visited;

    static int[][] mmap;

    static int num = 0;

    public static void dfs(int depth, int count, Pair cur) {
        if (depth == 4) {
            if(count > max){
                max = count;
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            int x = cur.x + dir_x[j];
            int y = cur.y + dir_y[j];
            if ((0 <= x && x < mmap.length) && (0 <= y && y < mmap[0].length)) {
                if (visited[x][y] == 0) {
                    visited[x][y] = 1;
                    dfs(depth + 1, count + mmap[x][y], new Pair(x, y));
                    visited[x][y] = 0;
                }
            }
        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        mmap = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int e = sc.nextInt();
                mmap[i][j] = e;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 1;
                dfs(1, mmap[i][j], new Pair(i, j));
                visited[i][j] = 0;
            }
        }

        for(int i = 0 ; i < N ; i ++ ){
            for(int j = 0 ; j < M ; j ++ ){
                //ㅏ
                if(i - 1 >= 0 && i + 1 < N && j + 1 < M){
                    int sum = mmap[i][j] + mmap[i - 1][j] + mmap[i + 1][j] + mmap[i][j + 1];
                    if(sum > max) max = sum;
                }
                //ㅓ
                if(i - 1 >= 0 && i + 1 < N && j - 1 >= 0){
                    int sum = mmap[i][j] + mmap[i - 1][j] + mmap[i + 1][j] + mmap[i][j - 1];
                    if(sum > max) max = sum;
                }
                //ㅜ
                if(j - 1 >= 0 && j + 1 < M && i + 1 < N){
                    int sum = mmap[i][j] + mmap[i + 1][j] + mmap[i][j - 1] + mmap[i][j + 1];
                    if(sum > max) max = sum;
                }
                //ㅗ
                if(j - 1 >= 0 && j + 1 < M && i - 1 >= 0){
                    int sum = mmap[i][j] + mmap[i - 1][j] + mmap[i][j - 1] + mmap[i][j + 1];
                    if(sum > max) max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
