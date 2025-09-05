import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int [][] mmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        mmap = new int[N][N];

        for(int i = 0 ; i < M ; i ++ ){
            String [] AB = br.readLine().split(" ");
            int a = Integer.parseInt(AB[0]) - 1;
            int b = Integer.parseInt(AB[1]) - 1;
            mmap[a][b] = 1;
            mmap[b][a] = 2;
        }

        int [][] cmp = new int[N][N];

        for(int i = 0 ; i < N ; i ++){
            int start_idx = i;

            Queue<Integer> mq = new LinkedList<>();
            mq.add(start_idx);
            while(!mq.isEmpty()){
                int cur_idx = mq.poll();
                for(int j = 0 ; j < N ; j ++ ){
                    if(mmap[cur_idx][j] == 1 && cmp[start_idx][j] == 0){
                        mq.add(j);
                        cmp[start_idx][j] = 1;
                    }
                }
            }

            mq.add(start_idx);
            while(!mq.isEmpty()){
                int cur_idx = mq.poll();
                for(int j = 0 ; j < N ; j ++ ){
                    if(mmap[cur_idx][j] == 2 && cmp[start_idx][j] == 0){
                        mq.add(j);
                        cmp[start_idx][j] = 2;
                    }
                }
            }

            cmp[i][i] = -1;
        }

        int cnt = 0;

        for(int i = 0 ; i < N ; i ++ ){
            int temp = 0;
            for(int j = 0 ; j < N ; j ++){
                if(cmp[i][j] != 0){
                    temp ++;
                }
            }
            if(temp == N) cnt ++ ;
        }

        System.out.println(cnt);
    }

}
