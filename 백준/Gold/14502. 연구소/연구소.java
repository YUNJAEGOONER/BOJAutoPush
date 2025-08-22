import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int [] visited;
    static int [][] mmap;

    static ArrayList<Integer> temp = new ArrayList<>();

    static int max = -1;

    static ArrayList<Pair> pairs = new ArrayList<>();

    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0 , 0, 1, -1};

    public static void bfs(ArrayList<Integer> arr){
        Queue<Pair> queue = new LinkedList<>();

        int [][] tempMap = new int[mmap.length][mmap[0].length];
        for (int i = 0; i < mmap.length; i++) {
            tempMap[i] = mmap[i].clone();
        }

        for(int i = 0 ; i < arr.size() ; i ++ ) {
            int x = pairs.get(arr.get(i)).x;
            int y = pairs.get(arr.get(i)).y;
            tempMap[x][y] = 1; //벽 설치
        }

        for(int i = 0 ; i < mmap.length ; i ++){
            for(int j = 0 ; j < mmap[0].length ; j ++ ){
                if(tempMap[i][j] == 2){
                    queue.add(new Pair(i, j));
                }
            }
        }

        //바이러스 퍼지기 시작
        while (!queue.isEmpty()){
            Pair top = queue.poll();
            for(int i = 0 ; i < 4 ; i ++ ){
                int x = top.x + dir_x[i];
                int y = top.y + dir_y[i];
                if((0 <= x && x < mmap.length) && (0 <= y && y < mmap[0].length)){
                    if(tempMap[x][y] == 0){
                        tempMap[x][y] = 2;
                        queue.add(new Pair(x, y));
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0 ; i < mmap.length ; i ++){
            for(int j = 0 ; j < mmap[0].length ; j ++ ){
                if(tempMap[i][j] == 0){
                    count++;
                }
            }
        }

        if(count > max){
            max = count;
        }
    }

    public static void bt(ArrayList<Integer> arr, int start){
        if (arr.size() == 3){
            bfs(arr);
            return;
        }
        for(int i = start ; i < visited.length ; i ++ ){
            if(visited[i] == 0){
                arr.add(i);
                visited[i] = 1;
                bt(arr, i);
                arr.remove(arr.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        mmap = new int[n][m];

        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < m ; j ++ ){
                int e = sc.nextInt();
                mmap[i][j] = e;
                if(e == 0){
                    pairs.add(new Pair(i, j));
                }
            }
        }

        visited = new int[pairs.size()];
        bt(temp, 0);
        System.out.println(max);
    }

}
