import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] mmap = new int [n][n];

        for(int i = 0 ; i < n; i ++ ){
            String [] rows = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++ ){
                mmap[i][j] = Integer.parseInt(rows[j]);
            }
        }

        int island = 1;
        boolean [][] visited = new boolean[n][n];

        Map<Integer, List<Pair>> islandMap = new HashMap<>();

        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < n ; j ++ ){
                List<Pair> mapList = new ArrayList<>();
                if(!visited[i][j] && mmap[i][j] == 1){
                    Queue<Pair> mq = new LinkedList<>();
                    mq.add(new Pair(i, j));
                    visited[i][j] = true;
                    mmap[i][j] = island;
                    mapList.add(new Pair(i, j));
                    while(!mq.isEmpty()){
                        Pair cur = mq.poll();
                        for(int k = 0 ; k < 4 ; k ++){
                            int x = cur.x + dir_x[k];
                            int y = cur.y + dir_y[k];
                            if((0 <= x && x < n) && (0 <= y && y < n) && !visited[x][y]){
                                if(mmap[x][y] == 1){
                                    visited[x][y] = true;
                                    mq.add(new Pair(x, y));
                                    mapList.add(new Pair(x, y));
                                    mmap[x][y] = island;
                                }
                            }
                        }
                    }
                    islandMap.put(island, mapList);
                    island++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 1; i < island - 1; i ++ ){
            for(int j = i + 1 ; j < island ; j ++ ){
                List<Pair> list1 = islandMap.get(i);
                List<Pair> list2 = islandMap.get(j);
                for(int I = 0 ; I < list1.size() ; I ++){
                    for(int J = 0 ; J < list2.size() ; J ++){
                        int distance = Math.abs(list1.get(I).x - list2.get(J).x) + Math.abs(list1.get(I).y - list2.get(J).y) - 1;
                        if(distance < answer) answer = distance;
                    }
                }
            }
        }

        System.out.println(answer);




    }

}
