import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//bt
public class Main {

    static class Pair{
        int x;
        int y;
        int c;

        public Pair(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int target;
    static int min = Integer.MAX_VALUE;
    static int [][] mmap;
    static int [][] tmap;
    static List<Pair> cameras = new ArrayList<>();

    public static void top(int start, int j){
        for(int i = start - 1; i > - 1 ; i --){
            if(tmap[i][j] == 0){
                tmap[i][j] = -1;
            }
            else if(tmap[i][j] == 6){
                break;
            }
        }
    }

    public static void bottom(int start, int j){
        for(int i = start + 1; i < tmap.length ; i ++){
            if(tmap[i][j] == 0){
                tmap[i][j] = -1;
            }
            else if(tmap[i][j] == 6){
                break;
            }
        }
    }

    public static void right(int i, int start){
        for(int j = start + 1; j < tmap[0].length ; j ++){
            if(tmap[i][j] == 0){
                tmap[i][j] = -1;
            }
            else if(tmap[i][j] == 6){
                break;
            }
        }
    }

    public static void left(int i, int start){
        for(int j = start - 1; j > -1; j --){
            if(tmap[i][j] == 0){
                tmap[i][j] = -1;
            }
            else if(tmap[i][j] == 6){
                break;
            }
        }
    }

    public static void bt(int depth, List<Integer> dir){
        if(depth == target){

            tmap = new int[mmap.length][mmap[0].length];
            for(int i = 0 ; i < mmap.length ; i ++ ){
                tmap[i] = mmap[i].clone();
            }

            for(int i = 0 ; i < cameras.size() ; i ++ ){
                int x = cameras.get(i).x;
                int y = cameras.get(i).y;
                int c = cameras.get(i).c;
                int d = dir.get(i);
                if(c == 1){
                    if(d == 0){
                        top(x, y);
                    }
                    else if(d == 1){
                        right(x, y);
                    }
                    else if(d == 2){
                        bottom(x, y);
                    }
                    else{
                        left(x, y);
                    }
                }
                else if(c == 2){
                    if(d == 0 || d == 2){
                        top(x, y);
                        bottom(x, y);
                    }
                    else{
                        left(x, y);
                        right(x, y);
                    }
                }
                else if(c == 3){
                    if(d == 0){
                        top(x, y);
                        right(x, y);
                    }
                    else if(d == 1){
                        right(x, y);
                        bottom(x, y);
                    }
                    else if(d == 2){
                        bottom(x, y);
                        left(x, y);
                    }
                    else{
                        left(x, y);
                        top(x, y);
                    }
                }
                else if(c == 4){
                    if(d == 0){
                        left(x, y);
                        top(x, y);
                        right(x, y);
                    }
                    else if(d == 1){
                        top(x, y);
                        right(x, y);
                        bottom(x, y);
                    }
                    else if(d == 2){
                        right(x, y);
                        bottom(x, y);
                        left(x, y);
                    }
                    else{
                        bottom(x, y);
                        left(x, y);
                        top(x, y);
                    }
                }
                else if(c == 5){
                    top(x, y);
                    right(x, y);
                    bottom(x, y);
                    left(x, y);
                }
            }

            int cnt = 0;
            for(int i = 0 ; i < tmap.length; i ++ ){
                for(int j = 0 ; j < tmap[0].length ; j ++ ){
                    if(tmap[i][j] == 0){
                        cnt ++;
                    }
                }
            }

            if(min > cnt) min = cnt;

            return;
        }

        for(int i = 0 ; i < 4 ; i ++){
            dir.add(i);
            bt(depth + 1, dir);
            dir.remove(dir.size() - 1);
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        mmap = new int[N][M];

        for(int i = 0 ; i < N ; i ++ ){
            String[] rows = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++ ){
                mmap[i][j] = Integer.parseInt(rows[j]);
                if(1 <= mmap[i][j] && mmap[i][j] <= 5){
                    target ++;
                    cameras.add(new Pair(i, j, mmap[i][j]));
                }
            }
        }

        bt(0, new ArrayList<>());
        System.out.println(min);

    }

}
