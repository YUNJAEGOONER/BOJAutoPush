import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] mmap;

    static int answer = -1;

    public static boolean checkAvailable() {
        for (int i = 0; i < mmap[0].length; i++) {
            int cur_x = 0;
            int cur_y = i;
            while (cur_x < mmap.length) {
                if (mmap[cur_x][cur_y] == 1){
                    cur_y ++;
                }
                else if(cur_y - 1 >= 0 && mmap[cur_x][cur_y - 1] == 1) {
                    cur_y --;
                }
                //그냥 밑으로 이동하기
                cur_x ++;
            }
            if (i != cur_y) {
                return false;
            }
        }
        return true;
    }

    public static void printMap(){
        System.out.println("=======================");
        for(int i = 0 ; i < mmap.length ; i ++){
            for(int j = 0 ; j < mmap[0].length ; j ++ ){
                System.out.print(mmap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bt(int start_x, int start_y, int cnt) {
        if(cnt > 3){
            return;
        }



        if (checkAvailable()) {
            if (answer == -1) {
                answer = cnt;
            } else {
                if (answer > cnt) {
                    answer = cnt;
                }
            }
        }

        for(int i = start_x ; i < mmap.length ; i ++ ){
            int j = 0;
            if(i == start_x){
                j = start_y;
            }
            for(j = j ; j < mmap[0].length - 1 ; j ++ ){
                if(mmap[i][j] == 0){
                    if((j == 0 && mmap[i][j + 1] == 0) || ((j - 1 >= 0 && mmap[i][j - 1] == 0) && (j + 1 < mmap[0].length && mmap[i][j + 1] == 0))){
                        mmap[i][j] = 1;
                        bt(i, j, cnt + 1);
                        mmap[i][j] = 0;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMH = br.readLine().split(" ");

        int N = Integer.parseInt(NMH[0]);
        int M = Integer.parseInt(NMH[1]);
        int H = Integer.parseInt(NMH[2]);

        mmap = new int[H][N];

        for (int i = 0; i < M; i++) {
            String[] stick = br.readLine().split(" ");

            int a = Integer.parseInt(stick[0]) - 1;
            int b = Integer.parseInt(stick[1]) - 1;

            mmap[a][b] = 1; //시작점에만 표시
        }

        bt(0, 0, 0);
        System.out.println(answer);
    }

}
