import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Pair{
        String pw;
        int depth;
        public Pair(String pw, int depth){
            this.pw = pw;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        boolean [] isPrime = new boolean[10000];

        for(int i = 2; i < 10000 ; i ++ ){
            isPrime[i] = true;
        }

        //에라스토테네스의 체
        for(int i = 2; i <= (int)Math.sqrt(9999) ; i ++ ){
            if(isPrime[i]){
                int num = i * i;
                while (num < 10000){
                    isPrime[num] = false;
                    num += i;
                }
            }
        }

        for(int t = 0 ; t < test ; t ++ ){

            boolean [] visited = new boolean[10000];

            String [] ab = br.readLine().split(" ");
            String now = ab[0];
            String target = ab[1];

            Queue<Pair> mq = new LinkedList<>();
            mq.add(new Pair(now, 0));
            visited[Integer.parseInt(now)] = true;
            int answer = -1;

            while (!mq.isEmpty()){
                Pair cur = mq.poll();
                String pw = cur.pw;
                int depth = cur.depth;

                if(pw.equals(target)){
                    answer = depth;
                    break;
                }

                char [] temp = new char[4];
                for(int i = 0 ; i < 4 ; i ++ ){
                    temp[i] = pw.charAt(i);
                }

                for(int i = 0 ; i < 4 ; i ++ ){
                    for(int j = 0 ; j < 10 ; j ++ ){
                        temp[i] ++;
                        if(temp[i] == 58){
                            temp[i] -= 10;
                        }
                        int num = Integer.parseInt(new String(temp));
                        if(num >= 1000 && isPrime[num] && !visited[num]){
                            mq.add(new Pair(new String(temp), depth + 1));
                            visited[num] = true;
                        }
                    }

                }


            }

            if(answer == -1){
                System.out.print("Impossible");
            }
            else{
                System.out.println(answer);
            }
        }

    }
}
