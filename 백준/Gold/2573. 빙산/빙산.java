import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int [][] mmap;

    static int [] dir_x = {1, -1, 0 , 0};
    static int [] dir_y = {0, 0, 1, -1};

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void updateMap(List<Pair> pairs){

        int [][] temp = mmap.clone();

        for (int i = 0; i < mmap.length; i++) {
            temp[i] = mmap[i].clone();
        }

        for(int i = 0 ; i < pairs.size() ; i ++ ){
            int cur_x = pairs.get(i).x;
            int cur_y = pairs.get(i).y;
            for(int j = 0 ; j < dir_x.length ; j ++ ){
                int x = cur_x + dir_x[j];
                int y = cur_y + dir_y[j];
                if(0 <= x && x < mmap.length && 0 <= y && y < mmap[0].length){
                    if(mmap[x][y] == 0){
                        if(temp[cur_x][cur_y] > 0){
                            temp[cur_x][cur_y] --;
                        }
                    }
                }
            }
        }

        mmap = temp;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        mmap = new int[N][M];

        List<Pair> arrayList = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++ ){
            String [] row = br.readLine().split(" ");
            for(int j = 0 ; j < row.length ; j ++ ){
                mmap[i][j] = Integer.parseInt(row[j]);
                if(mmap[i][j] != 0){
                    arrayList.add(new Pair(i, j));
                }
            }
        }

        int answer = 0;
        boolean separate = false;

        while(!arrayList.isEmpty()){

            updateMap(arrayList);
            answer ++;

            List<Pair> updateList = new ArrayList<>();
            for(int i = 0 ; i < N ; i ++ ){
                for(int j = 0 ; j < M ; j ++ ){
                    if(mmap[i][j] != 0){
                        updateList.add(new Pair(i, j));
                    }
                }
            }

            if(updateList.isEmpty()){
                answer = 0;
                break;
            }
            else{

                int [][] visited = new int[N][M];
                Queue<Pair> mq = new LinkedList<>();
                mq.add(updateList.get(0));
                visited[updateList.get(0).x][updateList.get(0).y] = 1;
                int tempCnt = 1;

                while(!mq.isEmpty()){
                    Pair cur = mq.poll();
                    int cur_x = cur.x;
                    int cur_y = cur.y;

                    for(int i = 0 ; i < 4 ; i ++ ){
                        int x = cur_x + dir_x[i];
                        int y = cur_y + dir_y[i];
                        if(0 <= x && x < N && 0 <= y && y < M){
                            if(visited[x][y] == 0 && mmap[x][y] != 0){
                                visited[x][y] = 1;
                                tempCnt ++;
                                mq.add(new Pair(x, y));
                            }
                        }
                    }
                }

                //한번에 탐방이 가능
                if(tempCnt == updateList.size()){
                    arrayList = updateList;
                }
                else{
                    separate = true;
                    break;
                }
            }


        }

        System.out.println(answer);

    }

}
