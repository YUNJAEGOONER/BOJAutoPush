import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dir_x = {1, -1, 0, 0};
    static int[] dir_y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MNK = br.readLine().split(" ");

        int M = Integer.parseInt(MNK[0]); //5
        int N = Integer.parseInt(MNK[1]); //7
        int K = Integer.parseInt(MNK[2]);

        boolean[][] mmap = new boolean[M][N];

        for (int t = 0; t < K; t++) {
            String[] xyxy = br.readLine().split(" ");
            int y1 = Integer.parseInt(xyxy[0]); //0
            int x1 = Integer.parseInt(xyxy[1]); //2
            int y2 = Integer.parseInt(xyxy[2]) - 1; //4
            int x2 = Integer.parseInt(xyxy[3]) - 1; //4

            for (int i = x1; i <= x2; i ++) {
                for (int j = y1; j <= y2; j++) {
                    mmap[i][j] = true;
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Queue<Pair> mq = new LinkedList<>();
                int cnt = 0;
                if (!mmap[i][j]) {
                    cnt++;
                    mq.add(new Pair(i, j));
                    mmap[i][j] = true;
                    while (!mq.isEmpty()) {
                        Pair pair = mq.poll();
                        int x = pair.x;
                        int y = pair.y;
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dir_x[d];
                            int ny = y + dir_y[d];
                            if ((0 <= nx && nx < M) && (0 <= ny && ny < N)){
                                if(!mmap[nx][ny]) {
                                    mq.add(new Pair(nx, ny));
                                    mmap[nx][ny] = true;
                                    cnt++;
                                }
                            }

                        }
                    }
                    answer.add(cnt);
                }

            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for(int a : answer){
            System.out.print(a + " ");
        }

    }


}
