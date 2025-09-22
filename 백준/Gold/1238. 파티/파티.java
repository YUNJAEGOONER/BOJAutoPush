import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static List<List<Pair>> mmap = new ArrayList<>();

    public static class Pair implements Comparable<Pair>{
        int node;
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair o) {
            return this.distance - o.distance;
        }
    }

    public static int[] dijkstra(int start){
        // 데이크스트라 (특정 노드에서 나머지 노드까지의 최단 거리)
        PriorityQueue<Pair> mq = new PriorityQueue<>();

        int [] visited = new int [mmap.size() + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;
        mq.add(new Pair(start, 0));

        while (!mq.isEmpty()){
            Pair cur_node = mq.poll();
            int node = cur_node.node;
            int distance= cur_node.distance;
            List<Pair> pairList = mmap.get(node);
            for(int i = 0 ; i < pairList.size() ; i ++ ){
                int des = pairList.get(i).node;
                int dis = pairList.get(i).distance;
                if(visited[des] > distance + dis){
                    visited[des] = dis + distance;
                    mq.add(new Pair(des, visited[des]));
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NMX = br.readLine().split(" ");

        int N = Integer.parseInt(NMX[0]);
        int M = Integer.parseInt(NMX[1]);
        int X = Integer.parseInt(NMX[2]);

        for(int i = 0 ; i < N + 1 ; i ++ ){
            mmap.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i ++ ){
            String [] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            //단방향
            mmap.get(a).add(new Pair(b, w));
        }

        int [] go = new int[N + 1];
        for(int i = 1; i < N + 1; i ++ ){
            go[i] = dijkstra(i)[X];
        }

        int [] back = new int[N + 1];
        back = dijkstra(X);

        int max = -1;
        for(int i = 1 ; i < N + 1 ; i ++ ){
            if(max < go[i] + back[i]){
                max = go[i] + back[i];
            }
        }

        System.out.println(max);


    }
}
