import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i ++ ){

            int N = sc.nextInt();
            int [] arr = new int [N];

            for(int j = 0 ; j < N ; j ++ ){
                int e = sc.nextInt();
                arr[j] = e;
            }

            int [][] records = new int [N + 1][5];
            for(int j = 0 ; j < N ; j ++){
                int cur_value = arr[j];
                 if(records[cur_value][0] == 0){
                     records[cur_value][0] = cur_value;
                 }
                 records[cur_value][1] ++;
            }

            int score = 1;
            for(int j = 0 ; j < N ; j ++ ){
                int cur_value = arr[j];
                if(records[cur_value][1] == 6) {
                    records[cur_value][3]++;
                    if(records[cur_value][3] <= 4) {
                        records[cur_value][2] += score;
                    }
                    if (records[cur_value][3] == 5) {
                        records[cur_value][4] = score;
                    }
                    score++;
                }
            }

            Arrays.sort(records, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[2] == o2[2]){
                        return o1[4] - o2[4];
                    }
                    return o1[2] - o2[2];
                }
            });

            int answer = -1;

            for(int k = 0 ; k < N + 1 ; k ++ ){
                if(records[k][1] == 6 && answer == -1){
                    answer = records[k][0];
                }
            }

            System.out.println(answer);

        }
    }
}
