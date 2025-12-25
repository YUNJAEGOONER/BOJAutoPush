import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    static class Pair {
        int id;
        int score;

        Pair(int id, int score){
            this.id = id;
            this.score = score;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i ++ ){
            String [] nktm = br.readLine().split(" ");

            int n = Integer.parseInt(nktm[0]); // 팀의 수
            int k = Integer.parseInt(nktm[1]); // 문제 수
            int t = Integer.parseInt(nktm[2]) - 1; // ID 내 팀
            int m = Integer.parseInt(nktm[3]); // 로그

            // 팀 - 문제 번호
            int [][] scoreMap = new int [n][k];

            // 0 : 풀이 횟수 + 1 : 제출시간
            int [][] ps = new int[n][2];

            for(int j = 0 ; j < m ; j ++ ){
                String [] ijs = br.readLine().split(" ");
                int id = Integer.parseInt(ijs[0]) - 1;
                int num = Integer.parseInt(ijs[1]) - 1;
                int score = Integer.parseInt(ijs[2]);

                if(scoreMap[id][num] < score){
                    scoreMap[id][num] = score;
                }

                ps[id][0] ++;
                ps[id][1] = j;

            }

            List<Integer> myList = new ArrayList<>();
            for(int j = 0 ; j < n ; j ++ ){
                int sum = 0;
                for(int l = 0 ; l < k ; l ++ ){
                    sum += scoreMap[j][l];
                }
                myList.add(sum);
            }

            int standard = myList.get(t);
            int cnt = 0;
            for(int j = 0 ; j < n ; j ++ ){
                if(standard < myList.get(j)){
                    cnt ++;
                }
                else if(standard == myList.get(j)){
                    //제출 횟수가 더 적고
                    if(ps[t][0] > ps[j][0]){
                        cnt ++;
                    }
                    //제출 시간이 빠른 경우
                    else if(ps[t][0] == ps[j][0]){
                        if(ps[t][1] > ps[j][1]){
                            cnt ++;
                        }
                    }
                }
            }

            System.out.println(cnt + 1);


        }

    }
}
