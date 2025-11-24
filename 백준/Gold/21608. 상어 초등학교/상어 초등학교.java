import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int [] dir_x = {-1, 1, 0 , 0};
    static int [] dir_y = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] result = new int[N][N];

        List<List<Integer>> mmap = new ArrayList<>();
        List<Integer> order = new ArrayList<>();

        for(int i = 0 ; i < (N * N) + 1 ; i ++){
            mmap.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N * N ; i ++ ){
            String [] input = br.readLine().split(" ");
            int cur = Integer.parseInt(input[0]);
            order.add(cur);
            List<Integer> friend = mmap.get(cur);
            for(int j = 1 ; j < input.length ; j ++ ){
                friend.add(Integer.parseInt(input[j]));
            }
        }

        for(int k = 0 ; k < order.size() ; k ++ ){
            int cur = order.get(k);
            List<Integer> friends = mmap.get(cur);

            int seat_x = -1;
            int seat_y = -1;
            int count = -1;
            int empty = -1;

            for(int i = 0 ; i < N ; i ++ ){
                for(int j = 0 ; j < N ; j ++ ){
                    if(result[i][j] == 0) { // 아무도 없는 자리일때
                        int cnt = 0;
                        int frei = 0;
                        for (int d = 0; d < 4; d++) {
                            int x = i + dir_x[d];
                            int y = j + dir_y[d];
                            if ((0 <= x && x < N) && (0 <= y && y < N)) {
                                if (result[x][y] == 0) {
                                    frei++; //비어있는
                                } else if (friends.contains(result[x][y])) {
                                    cnt++; //좋아하는 학생이 있는
                                }
                            }
                        }

                        if(count < cnt) {
                            seat_x = i;
                            seat_y = j;
                            count = cnt;
                            empty = frei;
                        }
                        else if(cnt == count){
                            if(empty < frei){
                                seat_x = i;
                                seat_y = j;
                                empty = frei;
                            }
                            else if (empty == frei){
                                if(seat_x > i){
                                    seat_x = i;
                                    seat_y = j;
                                }
                                else if(seat_x == i){
                                    if(seat_y > j){
                                        seat_y = j;
                                    }

                                }
                            }
                        }
                    }


                }
            }
            result[seat_x][seat_y] = cur;
        }

        int answer = 0 ;
        for(int i = 0 ; i < N ; i ++ ){
            for(int j = 0 ; j  < N ; j ++ ){
                int cur = result[i][j];
                List<Integer> friends = mmap.get(cur);
                int cnt = 0;
                for(int d = 0 ; d < 4 ; d ++){
                    int x = i + dir_x[d];
                    int y = j + dir_y[d];
                    if((0 <= x && x < N) && (0 <= y && y < N)){
                        if(friends.contains(result[x][y])){
                            cnt ++;
                        }
                    }
                }

                if(cnt == 4){
                    answer += 1000;
                }
                else if (cnt == 3){
                    answer += 100;
                }
                else if(cnt == 2){
                    answer += 10;
                }
                else if(cnt == 1){
                    answer += 1;
                }
            }
        }

        System.out.println(answer);

    }

}
