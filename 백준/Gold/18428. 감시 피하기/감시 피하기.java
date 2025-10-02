import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    static List<Pair> emptyList;
    static List<Pair> teacherList;
    static int [] visited;
    static char [][] mmap;

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};

    static int possible = 0;

    public static void bt(int depth, int start){

        if(depth == 3 && possible == 0){

            for(int i = 0 ; i < visited.length ; i ++ ){
                if(visited[i] == 1){
                    Pair newCamera = emptyList.get(i);
                    mmap[newCamera.x][newCamera.y] = 'O';
                }
            }

            boolean student = false;

            for(int i = 0 ; i < teacherList.size() ; i ++){
                Pair cur = teacherList.get(i);
                int cur_x = cur.x;
                int cur_y = cur.y;
                //하
                for(int x = cur_x; x < mmap.length ; x ++ ){
                    if (mmap[x][cur_y] == 'S') student = true;
                    else if(mmap[x][cur_y] == 'O') break;
                }

                //상
                for(int x = cur_x; x > -1 ; x -- ){
                    if (mmap[x][cur_y] == 'S') student = true;
                    else if(mmap[x][cur_y] == 'O') break;
                }

                //우
                for(int y = cur_y; y < mmap.length ; y ++ ){
                    if (mmap[cur_x][y] == 'S') student = true;
                    else if(mmap[cur_x][y] == 'O') break;
                }

                //좌
                for(int y = cur_y; y > -1 ; y -- ){
                    if (mmap[cur_x][y] == 'S') student = true;
                    else if(mmap[cur_x][y] == 'O') break;
                }
            }

            if(!student){
                possible = 1;
            }

            for(int i = 0 ; i < visited.length ; i ++ ){
                if(visited[i] == 1){
                    Pair newCamera = emptyList.get(i);
                    mmap[newCamera.x][newCamera.y] = 'X';
                }
            }
            return;

        }

        for(int i = start; i < emptyList.size() ; i ++){
            if(visited[i] == 0){
                visited[i] = 1;
                bt(depth + 1, i + 1);
                visited[i] = 0;
            }
            if(possible == 1){
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mmap = new char [n][n];
        emptyList = new ArrayList<>();
        teacherList = new ArrayList<>();

        for(int i = 0 ; i < n ; i ++ ){
            String[] row = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++ ){
                mmap[i][j] = row[j].charAt(0);
                if(mmap[i][j] == 'X'){
                    emptyList.add(new Pair(i, j));
                }
                else if(mmap[i][j] == 'T'){
                    teacherList.add(new Pair(i, j));
                }
            }
        }

        visited = new int[emptyList.size()];
        bt(0, 0);

        if(possible == 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

}
