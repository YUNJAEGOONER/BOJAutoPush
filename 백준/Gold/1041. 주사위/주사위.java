import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static long [] dice;
    static long threeMin;
    static long twoMin;
    static int [] opposite = {0, 1, 2, 2, 1, 0};

    public static long getTwo(){
        long temp = Integer.MAX_VALUE;
        for(int i = 0 ; i < dice.length ; i ++ ){
            for(int j = 0 ; j < dice.length ; j ++ ){
                if(i == j || opposite[i] == opposite[j]) continue;
                temp = Math.min(temp, dice[i] + dice[j]);
            }
        }
        return temp;
    }

    public static void bt(int start, List<Integer> temp){
        if(temp.size() == 3){
            boolean [] visited = new boolean[3];
            int sum = 0;
            for(int a : temp){
                int side = opposite[a];
                if(visited[side]) return;
                visited[side] = true;
                sum += dice[a];
            }
            threeMin = Math.min(threeMin, sum);
            return;
        }
        for(int i = start ; i < 6 ; i ++ ){
            temp.add(i);
            bt(i + 1, temp);
            temp.remove(temp.size() - 1);
        }

    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        String inputs[] = br.readLine().split(" ");
        dice = new long[6];

        for (int i = 0; i < inputs.length; i++) {
            dice[i] = Long.parseLong(inputs[i]);
        }



        long answer = 0;
        threeMin = Long.MAX_VALUE;
        bt(0, new ArrayList<>());

        twoMin = getTwo();
        Arrays.sort(dice);
        long min1 = dice[0];

        if (n == 1) {
            answer += (dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
        } else {
            //top 윗면
            answer += ((n - 2) * (n - 2)) * min1;

            //front 앞면
            answer += ((n - 2) * (n - 1)) * min1 * 4;

            //side + 윗면
            answer += (((n - 2) * 4) + ((n - 1) * 4)) * twoMin;

            //edge
            answer += 4 * threeMin;
        }



        System.out.println(answer);


    }
}
