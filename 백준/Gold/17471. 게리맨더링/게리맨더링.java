import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static boolean [] visited;

    static int [] population;

    static boolean [][] adj;

    static int answer;

    public static boolean checkAvailable(List<Integer> list){

        if(list.isEmpty()){
            return false;
        }

        boolean [] team = new boolean[visited.length];

        for(int i : list){
            team[i] = true;
        }

        boolean [] available = new boolean[visited.length];

        Queue<Integer> mq = new LinkedList<>();
        mq.add(list.get(0));
        available[list.get(0)] = true;

        while (!mq.isEmpty()){
            int cur = mq.poll();
            for(int i = 0 ; i < adj.length ; i ++ ){
                if(adj[cur][i] && team[i] && !available[i]){
                    mq.add(i);
                    available[i] = true;
                }
            }
        }

        for(int i = 0 ; i < adj.length ; i ++ ){
            if(available[i] != team[i]){
                return false;
            }
        }

        return true;

    }

    public static void bt(int start){
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();

        for(int i = 0 ; i < visited.length ; i ++){
            if(visited[i]){
                team1.add(i);
            }
            else{
                team2.add(i);
            }
        }

        if(checkAvailable(team1) && checkAvailable(team2)){

            int sum = 0;
            for(int i : team1){
                sum += population[i];
            }

            for(int i : team2){
                sum -= population[i];
            }

            sum = Math.abs(sum);

            answer = (answer == -1) ? sum : Math.min(answer, sum);

        }

        for(int i = start ; i < visited.length ; i ++ ){
            visited[i] = true;
            bt(i + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 구역의 개수

        population = new int[N];

        String [] input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++ ){
            population[i] = Integer.parseInt(input[i]);
        }

        visited = new boolean[N];
        visited[0] = true;

        adj = new boolean[N][N];

        for(int i = 0 ; i < N ; i ++ ){
            String [] relation = br.readLine().split(" ");
            for(int j = 0 ; j < relation.length - 1 ; j ++ ){
                int temp = Integer.parseInt(relation[j + 1]) - 1;
                adj[i][temp] = true;
                adj[temp][i] = true;
            }
        }

        answer = -1;

        bt(1);

        System.out.println(answer);

    }
}
