import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static class Pair implements Comparable<Pair>{
        int x;
        int d;

        public Pair(int x, int d){
            this.x = x;
            this.d = d;
        }

        @Override
        public int compareTo(Pair other){
            return this.d - other.d;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NE = br.readLine().split(" ");

        int N = Integer.parseInt(NE[0]);
        int E = Integer.parseInt(NE[1]);

        List<List<Pair>> mmap = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i ++ ){
            mmap.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] nw = br.readLine().split(" ");
            int v1 = Integer.parseInt(nw[0]);
            int v2 = Integer.parseInt(nw[1]);
            int e = Integer.parseInt(nw[2]);
            mmap.get(v1).add(new Pair(v2, e));
            mmap.get(v2).add(new Pair(v1, e));
        }

        String[] target = br.readLine().split(" ");
        int t1 = Integer.parseInt(target[0]);
        int t2 = Integer.parseInt(target[1]);

        //3번의 데이크스트라
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //startNode = 1;
        int [] visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        visited[0] = 0;
        visited[1] = 0;
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()){

            Pair cur = pq.poll();
            int cur_x = cur.x;
            int distance = cur.d;

            List<Pair> pairList = mmap.get(cur_x);
            for(int i = 0 ; i < pairList.size() ; i ++){
                int des = pairList.get(i).x;
                int dis = pairList.get(i).d;
                if(visited[des] > distance + dis){
                    visited[des] = distance + dis;
                    pq.add(new Pair(des, visited[des]));
                }
            }
        }

        //startNode = t1;
        int [] vertex1 = new int[N + 1];
        Arrays.fill(vertex1, Integer.MAX_VALUE);
        pq.clear();

        vertex1[0] = 0;
        vertex1[t1] = 0;
        pq.add(new Pair(t1, 0));

        while (!pq.isEmpty()){
            Pair cur = pq.poll();
            int cur_x = cur.x;
            int distance = cur.d;
            List<Pair> pairList = mmap.get(cur_x);
            for(int i = 0 ; i < pairList.size() ; i ++){
                int x = pairList.get(i).x;
                int dis = pairList.get(i).d;
                if(vertex1[x] > distance + dis){
                    vertex1[x] = distance + dis;
                    pq.add(new Pair(x, vertex1[x]));
                }
            }
        }

        //startNode = t2;
        int [] vertex2 = new int[N + 1];
        Arrays.fill(vertex2, Integer.MAX_VALUE);
        pq.clear();

        vertex2[0] = 0;
        vertex2[t2] = 0;
        pq.add(new Pair(t2, 0));

        while (!pq.isEmpty()){
            Pair cur = pq.poll();
            int cur_x = cur.x;
            int distance = cur.d;
            List<Pair> pairList = mmap.get(cur_x);
            for(int i = 0 ; i < pairList.size() ; i ++){
                int x = pairList.get(i).x;
                int dis = pairList.get(i).d;
                if(vertex2[x] > distance + dis){
                    vertex2[x] = distance + dis;
                    pq.add(new Pair(x, vertex2[x]));
                }
            }
        }

        int circuit1 = Integer.MAX_VALUE;
        if(visited[t1] != Integer.MAX_VALUE && vertex1[t2] != Integer.MAX_VALUE && vertex2[N] != Integer.MAX_VALUE){
            circuit1 = visited[t1] + vertex1[t2] + vertex2[N];
        }

        int circuit2 = Integer.MAX_VALUE;
        if(visited[t2] != Integer.MAX_VALUE && vertex2[t1] != Integer.MAX_VALUE && vertex1[N] != Integer.MAX_VALUE){
            circuit2 = visited[t2] + vertex2[t1] + vertex1[N];
        }

        if(circuit1 == Integer.MAX_VALUE && circuit2 == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            int answer = (circuit1 < circuit2) ? circuit1 : circuit2;
            System.out.println(answer);
        }

    }

}
