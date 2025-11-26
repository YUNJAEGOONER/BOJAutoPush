import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] CN = br.readLine().split(" ");
        int c = Integer.parseInt(CN[0]);
        int n = Integer.parseInt(CN[1]);

        List<Pair> pairList = new ArrayList<>();

        for(int i = 0 ; i < n ; i ++ ){
            String [] ab = br.readLine().split(" ");
            pairList.add(new Pair(Integer.parseInt(ab[0]), Integer.parseInt(ab[1])));
        }

        int [] dp = new int[100001];

        for(int i = 0 ; i < n ; i ++ ){
            Pair cur = pairList.get(i);
            int cost = cur.x;
            int people = cur.y;
            for(int j = 1 ; j < 100001 ; j ++ ){
                if(j - cost == 0 && dp[cost] == 0){
                    dp[cost] = people;
                }
                else if(0 <= j - cost){
                    if(dp[j] == 0){
                        dp[j] = dp[j - cost] + people;
                    }
                    else{
                        int max = Math.max(dp[j], dp[j - cost] + people);
                        dp[j] = max;
                    }
                }
            }
        }

        for(int i = 0 ; i < 100001 ; i ++ ){
            if(dp[i] >= c){
                System.out.println(i);
                break;
            }
        }


    }

}
