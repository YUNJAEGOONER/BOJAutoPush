import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Pair{
        int x;
        int cnt;
        public Pair(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int [] visited = new int [100001];

        Queue<Pair> mq = new LinkedList<>();
        mq.add(new Pair(N, 1));
        visited[N] = 1;

        int min = -1;
        int answer = 0;

        while (!mq.isEmpty()) {
            Pair cur = mq.poll();
            int x = cur.x;
            int cnt = cur.cnt;

            if (x == K) {
                if (min == -1) {
                    min = cnt;
                    answer++;
                } else if (min == cnt) {
                    answer++;
                }
            }

            if (x + 1 < 100001 && (visited[x + 1] == 0 || visited[x + 1] >= cnt + 1)) {
                mq.add(new Pair(x + 1, cnt + 1));
                visited[x + 1] = cnt + 1;
            }
            if (x - 1 >= 0 && (visited[x - 1] == 0 || visited[x - 1] >= cnt + 1)) {
                mq.add(new Pair(x - 1, cnt + 1));
                visited[x - 1] = cnt + 1;
            }
            if (2 * x < visited.length && (visited[2 * x] == 0 || visited[2 * x] >= cnt + 1)) {
                mq.add(new Pair(2 * x, cnt + 1));
                visited[2 * x] = cnt + 1;
            }

        }

        System.out.println(min - 1);
        System.out.println(answer);

    }

}