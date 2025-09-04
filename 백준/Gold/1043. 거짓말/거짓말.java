import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]); // 사람 수
        int M = Integer.parseInt(NM[1]); // 파티 수

        int[] trueman;
        String[] trues = br.readLine().split(" ");

        Queue<Integer> mq = new LinkedList<>();

        if (trues.length > 1) {
            trueman = new int[trues.length - 1];
            for (int i = 1; i < trues.length; i++) {
                trueman[i - 1] = Integer.parseInt(trues[i]) - 1;
                mq.add(trueman[i - 1]);
            }
        }

        int[][] relation = new int[N][N];
        int[][] party = new int[M][N];

        for (int i = 0; i < M; i++) { //파티
            String[] participate = br.readLine().split(" ");
            for (int j = 1; j < participate.length; j++) {
                for (int k = j + 1; k < participate.length; k++) {
                    int a = Integer.parseInt(participate[j]) - 1;
                    int b = Integer.parseInt(participate[k]) - 1;
                    relation[a][b] = 1;
                    relation[b][a] = 1;
                }
                int people = Integer.parseInt(participate[j]) - 1;
                party[i][people] = 1;
            }
        }

        int[] talk = new int[N];

        while (!mq.isEmpty()) {
            int people = mq.poll();
            if (talk[people] == 0) {
                talk[people] = 1;
                for (int i = 0; i < N; i++) {
                    if (talk[i] == 0 && relation[people][i] == 1) {
                        mq.add(i);
                    }
                }
            }
        }

        int cnt = M;

        int[] visited = new int[M];

        for (int i = 0; i < talk.length; i++) {
            if (talk[i] == 1) {
                for (int j = 0; j < M; j++) {
                    if (visited[j] == 0 && party[j][i] == 1) {
                        visited[j] = 1;
                        cnt--;
                    }
                }
            }
        }

        System.out.println(cnt);

    }

}
