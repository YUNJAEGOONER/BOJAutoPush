import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test ; t ++ ){
            int n = Integer.parseInt(br.readLine()); //맥주를 파는 편의점의 개수

            // 상근
            String [] locate = br.readLine().split(" ");
            int s_x = Integer.parseInt(locate[0]);
            int s_y = Integer.parseInt(locate[1]);

            //전체 노드
            List<Pair> arr = new ArrayList<>();

            // 편의점
            for(int i = 0 ; i < n ; i ++ ){
                String [] store = br.readLine().split(" ");
                int store_x = Integer.parseInt(store[0]);
                int store_y = Integer.parseInt(store[1]);
                arr.add(new Pair(store_x, store_y));
            }

            // 펜타포트 위치
            String [] festival = br.readLine().split(" ");
            int f_x = Integer.parseInt(festival[0]);
            int f_y = Integer.parseInt(festival[1]);
            arr.add(new Pair(f_x, f_y));

            //bfs를 위한 visit과 queue
            int [] visited = new int[arr.size()];
            Queue<Pair> mq = new LinkedList<>();
            mq.add(new Pair(s_x, s_y));

            while(!mq.isEmpty()){
                Pair current = mq.poll();
                int x = current.x;
                int y = current.y;
                for(int i = 0 ; i < arr.size() ; i ++ ){
                    Pair des = arr.get(i);
                    if(visited[i] == 0 && getDistance(x, y, des.x, des.y) <= 1000){
                        visited[i] = 1;
                        mq.add(des);
                    }
                }
            }

            if(visited[visited.length - 1] == 1){
                System.out.println("happy");
            }
            else{
                System.out.println("sad");
            }
        }

    }

    public static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
