import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int F = Integer.parseInt(st.nextToken()); //최대층
       int S = Integer.parseInt(st.nextToken()); //현재
       int G = Integer.parseInt(st.nextToken()); //목표
       int U = Integer.parseInt(st.nextToken());
       int D = Integer.parseInt(st.nextToken());


       boolean [] visited = new boolean [F + 1];
       int [] directions = new int [2];
       int [] depth = new int [F + 1];

       directions[0] = U;
       directions[1] = -D;

       Queue<Integer> mq = new LinkedList<>();
       mq.add(S);

       boolean result = false;

       while(!mq.isEmpty()){
           int cur = mq.poll();
           visited[cur] = true;
           if(cur == G){
               result = true;
               break;
           }
           for(int i = 0 ; i < directions.length ; i ++ ){
               int cur_depth = depth[cur];
               int moved = cur + directions[i];
               if(1 <= moved && moved <= F && visited[moved] == false){
                   mq.add(moved);
                   depth[moved] = cur_depth + 1;
                   visited[moved] = true;
               }
           }
       }

       if(result){
           System.out.print(depth[G]);
       }
       else{
           System.out.print("use the stairs");
       }


    }
}
