import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

    static char [][] mmap;

    public static void printMap(){
        for(int i = 0 ; i < mmap.length ; i ++ ){
            for(int j = 0 ; j < mmap[0].length ; j ++ ){
                System.out.print(mmap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] RC = br.readLine().split(" ");

        int R = Integer.parseInt(RC[0]);
        int C = Integer.parseInt(RC[1]);

        mmap = new char[R][C];
        boolean [][] visited = new boolean[R][C];

        Queue<Pair> fireList = new LinkedList<>();
        Queue<Pair> jihunList = new LinkedList<>();

        for(int i = 0 ; i < R ; i ++ ) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                mmap[i][j] = input.charAt(j);
                if (mmap[i][j] == 'F') {
                    fireList.add(new Pair(i, j));
                }
                else if(mmap[i][j] == 'J'){
                    mmap[i][j] = '.';
                    jihunList.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int answer = -1;
        int cnt = 0;

        while (!jihunList.isEmpty() && answer == -1){
            cnt ++;
            //매초 불 확산
            int fireListSize = fireList.size();
            for(int i = 0 ; i < fireListSize ; i ++){
                Pair pair = fireList.poll();
                for(int j = 0 ; j < 4 ; j ++ ){
                    int x = pair.x + dir_x[j];
                    int y = pair.y + dir_y[j];
                    if((0 <= x && x < R) && (0 <= y && y < C)){
                        if(mmap[x][y] == '.'){
                            mmap[x][y] = 'F';
                            fireList.add(new Pair(x, y));
                        }
                    }
                }
            }

            //jihun 이동
            int jihunListSize = jihunList.size();
            for(int i = 0 ; i < jihunListSize; i ++ ){
                Pair pair = jihunList.poll();
                for(int j = 0 ; j < 4 ; j ++ ){
                    int x = pair.x + dir_x[j];
                    int y = pair.y + dir_y[j];
                    if((0 <= x && x < R) && (0 <= y && y < C)){
                        if(mmap[x][y] == '.' && !visited[x][y]){
                            visited[x][y] = true;
                            jihunList.add(new Pair(x, y));
                        }
                    }
                    else{
                        answer = cnt;
                        break;
                    }
                }
                if(answer != -1){
                    break;
                }
            }
        }

        if(answer == -1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(answer);
        }

    }

}
