import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Pair{
        int x;
        int y;
        int state;
        public Pair(int x, int y, int state){
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }

    static int [][] mmap;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        mmap = new int[n][n];

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                int e = sc.nextInt();
                mmap[i][j] = e;
            }
        }

        Queue<Pair> mq = new LinkedList<>();
        mq.add(new Pair(0, 1, 0));

        int answer = 0;

        while(!mq.isEmpty() && mmap[n - 1][n - 1] != 1){
            Pair pair = mq.poll();
            int x = pair.x;
            int y = pair.y;
            if(x == n - 1 && y == n - 1) answer ++;
            if(pair.state == 0 || pair.state == 2){
                if(y + 1 < n && mmap[x][y + 1] == 0){
                    mq.add(new Pair(x, y + 1, 0));
                }
            }
            if(pair.state == 1 || pair.state == 2){
                if(x + 1 < n && mmap[x + 1][y] == 0){
                    mq.add(new Pair(x + 1, y, 1));
                }
            }
            if(x + 1 < n && y + 1 < n && mmap[x + 1][y + 1] == 0){
                if(mmap[x + 1][y] == 0 && mmap[x][y + 1] == 0){
                    mq.add(new Pair(x + 1, y + 1, 2));
                }
            }
        }

        System.out.println(answer);

    }

}