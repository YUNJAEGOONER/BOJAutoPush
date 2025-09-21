import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] mmap = new int[101][101];

        for (int i = 0; i < N; i++) {
            String[] xydg = br.readLine().split(" ");

            int x = Integer.parseInt(xydg[0]);
            int y = Integer.parseInt(xydg[1]);
            int d = Integer.parseInt(xydg[2]);
            int g = Integer.parseInt(xydg[3]);

            int[] dir = new int[(int) Math.pow(2.0, g)];
            dir[0] = d;

            for (int j = 0; j < g; j++) {
                double max = Math.pow(2.0, j);
                for (int k = 0; k < max; k++) {
                    dir[(int) (max * 2 - 1) - k] = (dir[k] + 1) % 4;
                }
            }

            mmap[y][x] = 1;

            for (int j = 0; j < dir.length; j++) {
                if (dir[j] == 0) {
                    x = x + 1;
                } else if (dir[j] == 1) {
                    y = y - 1;
                } else if (dir[j] == 2) {
                    x = x - 1;
                } else {
                    y = y + 1;
                }
                mmap[y][x] = 1;
            }

        }

        int cnt = 0;

        for(int i = 0 ; i < 101 ; i ++){
            for(int j = 0 ; j < 101 ; j ++ ){
                if(mmap[i][j] == 1){
                    if((i + 1 < 101 && j + 1 < 101) && mmap[i + 1][j] == 1 && mmap[i][j + 1] == 1 && mmap[i + 1][j + 1] == 1){
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}
