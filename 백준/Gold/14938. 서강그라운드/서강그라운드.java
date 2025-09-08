import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    //FLOYD WARSHALL
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMR = br.readLine().split(" ");

        int N = Integer.parseInt(NMR[0]);
        int M = Integer.parseInt(NMR[1]);
        int R = Integer.parseInt(NMR[2]);

        String [] strList =  br.readLine().split(" ");
        int [] values = new int[strList.length];
        for(int i = 0 ; i < values.length ; i ++ ){
            values[i] = Integer.parseInt(strList[i]);
        }

        int [][] mmap = new int[N][N];
        for(int i = 0 ; i < N ; i ++ ){
            Arrays.fill(mmap[i], Integer.MAX_VALUE);
            mmap[i][i] = 0;
        }


        for(int i = 0 ; i < R ; i ++ ){
            String [] roads = br.readLine().split(" ");
            int a = Integer.parseInt(roads[0]) - 1;
            int b = Integer.parseInt(roads[1]) - 1;
            int w = Integer.parseInt(roads[2]);

            mmap[a][b] = w;
            mmap[b][a] = w;
        }

        for(int k = 0 ; k < N ; k ++ ){
            for(int i = 0 ; i < N ; i ++ ){
                for(int j = 0 ; j < N ; j ++ ){
                    if(mmap[i][k] != Integer.MAX_VALUE && mmap[k][j] != Integer.MAX_VALUE){
                        if(mmap[i][j] > mmap[i][k] + mmap[k][j]){
                            mmap[i][j] = mmap[i][k] + mmap[k][j];
                        }
                    }
                }
            }
        }

        int max = -1;

        for(int i = 0 ; i < N ; i ++ ) {
            int sum = 0;
            for (int j = 0 ; j < N ; j ++ ) {
                if(mmap[i][j] <= M) sum += values[j];
            }
            if(max < sum) max = sum;
        }

        System.out.println(max);


    }
}
