import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int [] indegree;
    static int [][] adj;
    static Queue<Integer> mq;

    public static void initQueue(){
        for(int i = 0 ; i < indegree.length ; i ++ ){
            if(indegree[i] == 0){
                mq.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test ; t ++ ){
            String [] NK = br.readLine().split(" ");

            int N = Integer.parseInt(NK[0]); // 시간
            int K = Integer.parseInt(NK[1]); // 규칙

            adj = new int[N][N];
            indegree = new int[N];

            String [] times = br.readLine().split(" ");

            for(int i = 0 ; i < K ; i ++ ){
                String [] ab = br.readLine().split(" ");

                int a = Integer.parseInt(ab[0]) - 1;
                int b = Integer.parseInt(ab[1]) - 1;

                indegree[b] ++;
                adj[a][b] = 1;
            }

            int w = Integer.parseInt(br.readLine()) - 1;

            mq = new LinkedList<>();

            initQueue(); //queue에 indegree가 0인 노드 집어 넣기

            int [] result = new int[N];

            while (!mq.isEmpty()){
                int cur = mq.poll();
                int cur_time = Integer.parseInt(times[cur]);

                int max = 0;
                for(int i = 0 ; i < N ; i ++ ){
                    if(adj[i][cur] == 1){
                        max = Math.max(max, result[i]);
                    }
                }
                result[cur] += (max + cur_time);

                for(int i = 0 ; i < N ; i ++ ){
                    if(adj[cur][i] == 1){
                        indegree[i] -= 1;
                        if(indegree[i] == 0){
                            mq.add(i);     //indegree가 0인 경우
                        }
                    }
                }
            }

            System.out.println(result[w]);
        }
    }
}
