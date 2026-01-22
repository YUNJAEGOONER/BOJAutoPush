import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n = 12;

    static int m = 6;

    static char [][] mmap;

    static boolean [][] visited;

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void printMap(){
        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < m ; j ++ ){
                System.out.print(mmap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void updateMap(){
        for(int j = 0 ; j < m ; j ++ ){
            for(int i = n - 1 ; i > -1 ; i -- ){
                if(mmap[i][j] == 'x' || mmap[i][j] == '.'){
                    boolean check = false;
                    for(int k = i - 1 ; k > -1 ; k --){
                        if(mmap[k][j] == 'R' || mmap[k][j] == 'G' || mmap[k][j] == 'B' || mmap[k][j] == 'P' || mmap[k][j] == 'Y'){
                            mmap[i][j] = mmap[k][j];
                            mmap[k][j] = '.';
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        mmap[i][j] = '.';
                    }
                }
            }
        }
    }

    public static boolean puyo(){

        boolean puyo = false;

        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < m ; j ++ ){
                if((mmap[i][j] == 'R' || mmap[i][j] == 'G' || mmap[i][j] == 'B' || mmap[i][j] == 'P' || mmap[i][j] == 'Y') && !visited[i][j]){
                    char target = mmap[i][j];
                    Queue<Pair> mq = new LinkedList<>();
                    List<Pair> temp = new ArrayList<>();
                    temp.add(new Pair(i, j));
                    mq.add(new Pair(i, j));
                    visited[i][j] = true;

                    while (!mq.isEmpty()){
                        Pair cur = mq.poll();
                        int x = cur.x;
                        int y = cur.y;
                        for(int d = 0 ; d < 4 ; d ++ ){
                            int nx = x + dir_x[d];
                            int ny = y + dir_y[d];
                            if((0 <= nx && nx < n) && (0 <= ny && ny < m)){
                                if(!visited[nx][ny] && mmap[nx][ny] == target){
                                    mq.add(new Pair(nx, ny));
                                    temp.add(new Pair(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }

                    if(temp.size() >= 4){
                        puyo = true;
                        for(Pair p : temp){
                            mmap[p.x][p.y] = 'x';
                        }
                    }
                }
            }
        }

        return puyo;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mmap = new char[n][m];

        for(int i = 0 ; i < n ; i ++ ){
            String input = br.readLine();
            for(int j = 0 ; j < m ; j ++ ){
                mmap[i][j] = input.charAt(j);
            }
        }


        int answer = 0;

        while (true){
            if(!puyo()){
                break;
            }
            updateMap();
            answer ++;
        }

        System.out.println(answer);

    }
}
