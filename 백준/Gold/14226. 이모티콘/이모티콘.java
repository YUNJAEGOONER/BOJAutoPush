import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int [][] visited;

    static class Pair{
        int cnt;
        int clipboard;
        int time;
        public Pair(int cnt, int time, int clipboard){
            this.cnt = cnt;
            this.time = time;
            this.clipboard = clipboard;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int s = Integer.parseInt(input);

        int answer = 0;

        visited = new int[1001][1001];

        Queue<Pair> mq = new LinkedList<>();
        mq.add(new Pair(1, 0, 0));
        visited[1][0] = 0;

        while(!mq.isEmpty()){

            Pair pair = mq.poll();
            int cnt = pair.cnt;
            int time = pair.time;
            int clipboard = pair.clipboard;

            if(cnt == s){
                answer = time;
                break;
            }

            //copy
            if(visited[cnt][cnt] == 0){
                mq.add(new Pair(cnt, time + 1, cnt));
            }


            //paste
            if (cnt + clipboard <= 1000 && clipboard <= 1001) {
                if(visited[cnt + clipboard][clipboard] == 0){
                    visited[cnt + clipboard][clipboard] = time + 1;
                    mq.add(new Pair(cnt + clipboard, time + 1, clipboard));
                }
            }

            //remove_one
            if (cnt - 1 >= 0 && clipboard <= 1001) {
                if(visited[cnt - 1][clipboard] == 0){
                    visited[cnt - 1][clipboard] = time + 1;
                    mq.add(new Pair(cnt - 1, time + 1, clipboard));
                }
            }

        }

        System.out.println(answer);

    }
}
