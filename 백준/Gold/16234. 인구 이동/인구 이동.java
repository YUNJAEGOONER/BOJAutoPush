import java.util.*;

import static java.lang.Math.abs;

public class Main {

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        int [][] mmap = new int [N][N];
        for(int i = 0 ; i < N ; i ++ ){
            for(int j = 0 ; j < N ; j ++ ){
                int element = sc.nextInt();
                mmap[i][j] = element;
            }
        }

        int [] dir_x = {-1, 1, 0, 0};
        int [] dir_y = {0, 0, -1, 1};

        int day = 0;

        while(true){

            int [][] updatedMap = new int [N][N];

            boolean [][] visited = new boolean[N][N];
            boolean updated = false;

            for(int i = 0 ; i < N ; i ++){
                for(int j = 0 ; j < N ; j ++){

                    Queue<Node> mq = new LinkedList<>();
                    List<Node> mlist = new ArrayList<>();

                    mq.add(new Node(i, j));
                    mlist.add(new Node(i, j));

                    visited[i][j] = true;

                    int sum = 0;
                    while(!mq.isEmpty()){
                        Node now = mq.poll();
                        int x = now.x;
                        int y = now.y;
                        sum += mmap[x][y];
                        for(int k = 0 ; k < 4 ; k ++ ){
                            int cur_x = x + dir_x[k];
                            int cur_y = y + dir_y[k];
                            if(0 <= cur_x && cur_x < N && 0 <= cur_y && cur_y < N){
                                int diff = abs(mmap[x][y] -mmap[cur_x][cur_y]);
                                if(L <= diff && diff <= R && !visited[cur_x][cur_y]){
                                    visited[cur_x][cur_y] = true;
                                    mq.add(new Node(cur_x, cur_y));
                                    mlist.add(new Node(cur_x, cur_y));
                                }
                            }
                        }
                    }

                    if(mlist.size() > 1){
                        updated = true;
                        for(Node node : mlist){
                            updatedMap[node.x][node.y] = sum / mlist.size();
                        }
                    }

                }
            }

            for(int i = 0 ; i < N ; i ++ ){
                for(int j = 0 ; j < N ; j ++ ){
                    if(updatedMap[i][j] == 0){
                        updatedMap[i][j] = mmap[i][j];
                    }
                }
            }

            mmap = updatedMap;

            if(updated) day++;
            else break;

        }

        System.out.println(day);




    }
}
