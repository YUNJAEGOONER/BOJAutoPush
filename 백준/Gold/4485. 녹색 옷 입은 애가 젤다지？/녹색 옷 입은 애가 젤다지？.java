import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Node{
        int cost;
        int x;
        int y;
        Node(int cost, int x, int y){
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        int [] dir_x = {-1, 1, 0 ,0};
        int [] dir_y = {0, 0, -1, 1};

        Scanner sc = new Scanner(System.in);

        int cnt = 1;

        while(true){
            int N = sc.nextInt();
            if(N == 0){
                break;
            }
            else{
                int [][] mmap = new int [N][N];
                boolean [][] visited = new boolean [N][N];

                for(int i = 0 ; i < N ; i ++ ){
                    for(int j = 0 ; j < N ; j ++){
                        int element = sc.nextInt();
                        mmap[i][j] = element;
                    }
                }

                PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

                pq.add(new Node(mmap[0][0], 0, 0));

                int answer = 0;

                while(!pq.isEmpty()){
                    Node cur = pq.poll();
                    visited[cur.x][cur.y] = true;
                    if(cur.x == N - 1 && cur.y == N - 1){
                        answer = cur.cost;
                        break;
                    }
                    for(int i = 0 ; i < 4 ; i ++ ){
                        int cur_x = cur.x + dir_x[i];
                        int cur_y = cur.y + dir_y[i];
                        if(0 <= cur_x && cur_x < N && 0 <= cur_y && cur_y < N && visited[cur_x][cur_y] == false){
                            int cost = cur.cost + mmap[cur_x][cur_y];
                            pq.add(new Node(cost, cur_x, cur_y));
                        }
                    }
                }

                System.out.println("Problem " + cnt + ": " + answer);
                cnt ++;
            }
        }
    }
}
