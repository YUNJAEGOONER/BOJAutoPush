import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Pair{
        String str;
        int result;
        public Pair(String str, int result){
            this.str = str;
            this.result = result;
        }
    }

    public static int D(int num){
        return (num * 2) % 10000;
    }

    public static int S(int num){
        if(num == 0) return 9999;
        else return num - 1;
    }

    public static int L(int num){
        int temp = num * 10;
        temp %= 10000;
        return temp + (num / 1000);
    }

    public static int R(int num){
        int temp = num / 10;
        return temp + ((num % 10) * 1000);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i ++ ){

            String [] start_target = br.readLine().split(" ");
            int start = Integer.parseInt(start_target[0]);
            int target = Integer.parseInt(start_target[1]);

            int [] visited = new int[10000];
            visited[start] = 1;

            Queue<Pair> mq = new LinkedList<>();
            mq.add(new Pair("", start));

            while (!mq.isEmpty()){
                Pair cur = mq.poll();
                String str = cur.str;
                int result = cur.result;

                if(result == target){
                    System.out.println(str);
                    break;
                }

                int tempD = D(result);
                if(visited[tempD] == 0){
                    mq.add(new Pair(str + "D", tempD));
                    visited[tempD] = 1;
                }

                int tempS = S(result);
                if(visited[tempS] == 0){
                    mq.add(new Pair(str + "S", tempS));
                    visited[tempS] = 1;
                }

                int tempL = L(result);
                if(visited[tempL] == 0) {
                    mq.add(new Pair(str + "L", tempL));
                    visited[tempL] = 1;
                }

                int tempR = R(result);
                if(visited[tempR] == 0){
                    mq.add(new Pair(str + "R", tempR));
                    visited[tempR] = 1;
                }

            }


        }



    }

}
