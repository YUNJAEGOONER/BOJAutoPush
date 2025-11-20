import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static class Pair {
        int x; //위치
        int d; //거리
        public Pair(int x, int d){
            this.x = x;
            this.d = d;
        }
    }

    public static class Dot implements Comparable<Dot> {
        int from; //위치
        int to;
        int d; //거리

        public Dot(int from, int to, int d){
            this.from = from;
            this.to = to;
            this.d = d;
        }

        @Override
        public int compareTo(Dot dot){
            return this.d - dot.d;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //adj
        List<List<Pair>> mmap = new ArrayList<>();

        for(int i = 0 ; i < n + 1 ; i ++ ){
            mmap.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < m ; i ++ ){
            String [] info = br.readLine().split(" ");

            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            int c = Integer.parseInt(info[2]);

            mmap.get(a).add(new Pair(b, c));
        }

        int [][] result = new int[n + 1][2];

        for(int i = 1 ; i < n + 1 ; i ++ ){
            result[i][0] = -1;
        }

        String [] se = br.readLine().split(" ");
        int start = Integer.parseInt(se[0]);
        int end = Integer.parseInt(se[1]);

        PriorityQueue<Dot> pq = new PriorityQueue<>();
        pq.add(new Dot(0, start, 0));
        
        while (!pq.isEmpty()){
            Dot cur = pq.poll();
            int from = cur.from; // 이전 위치
            int to = cur.to;  // 지금 위치
            int dis = cur.d; // 거리

            if(result[to][0] == -1 || result[to][0] > dis){ // 방문을 x, 더 짧은 경로 발견
                result[to][0] = dis;
                result[to][1] = from;

                List<Pair> pairList = mmap.get(to);
                for(Pair pair : pairList){
                    if(result[pair.x][0] == -1) {
                        pq.add(new Dot(to, pair.x, dis + pair.d));
                    }
                    else if(result[pair.x][0] != -1 && (result[to][0] >= dis + pair.d)){
                        pq.add(new Dot(to, pair.x, dis + pair.d));
                    }
                }

            }

        }

        System.out.println(result[end][0]);
        
        List<Integer> path = new ArrayList<>();

        int cur = end;
        while (cur != 0){
            path.add(cur);
            cur = result[cur][1];
        }

        System.out.println(path.size());

        for (int i = path.size() - 1 ; i > - 1; i -- ){
            System.out.print(path.get(i) + " ");
        }

    }
}
