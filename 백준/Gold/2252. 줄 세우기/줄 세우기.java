import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<List<Integer>> adj;

    static int [] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        adj = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++ ){
            adj.add(new ArrayList<>());
        }

        inDegree = new int[N];

        for(int i = 0 ; i < M ; i ++ ){
            String [] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            adj.get(a).add(b);
            inDegree[b] ++;
        }

        Queue<Integer> mq = new LinkedList<>();
        for(int i = 0 ; i < N ; i ++ ){
            if(inDegree[i] == 0){
                mq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!mq.isEmpty()){
            int cur = mq.poll();
            sb.append(cur + 1).append(' ');

            for(int node : adj.get(cur)){
                inDegree[node] --;
                if(inDegree[node] == 0){
                    mq.add(node);
                }
            }
        }

        System.out.println(sb);

    }
}
