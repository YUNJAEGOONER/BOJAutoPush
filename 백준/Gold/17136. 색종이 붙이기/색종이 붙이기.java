import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int [][] arr;

    static int [] paper;

    //스티커를 붙이려는 지역이 전부 1인 경우
    public static boolean checkOne(int x, int y, int size){
        if((0 <= x && x + size <= arr.length) && (0 <= y && y + size <= arr.length)){
            for(int i = x ; i < x + size ; i ++ ){
                for(int j = y ; j < y + size ; j ++ ){
                    if(arr[i][j] == 0){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void toZero(int x, int y, int size){
        for(int i = x ; i < x + size ; i ++ ){
            for(int j = y ; j < y + size ; j ++ ){
                arr[i][j] = 0;
            }
        }
    }

    public static void toOne(int x, int y, int size){
        for(int i = x ; i < x + size ; i ++ ){
            for(int j = y ; j < y + size ; j ++ ){
                arr[i][j] = 1;
            }
        }
    }

    static int answer = Integer.MAX_VALUE;

    public static void bt(int cnt, int one){

        if(cnt >= answer){
            return;
        }

        if(one == 0){
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i = 0 ; i < arr.length ; i ++ ){
            for(int j = 0 ; j < arr.length ; j ++){
                if(arr[i][j] == 1){
                    for(int p = 5 ; p > 0 ; p -- ){
                        if(checkOne(i, j, p) && paper[p] >= 1){
                            paper[p]--;
                            toZero(i, j, p);
                            bt(cnt + 1, one - (p * p));
                            toOne(i, j, p);
                            paper[p]++;
                        }
                    }
                    return; 
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[10][10];

        paper = new int[6];
        Arrays.fill(paper, 5);

        int one = 0;
        for(int i = 0 ; i < 10 ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < 10 ; j ++ ){
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j] == 1){
                    one++;
                }
            }
        }

        bt(0, one);
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;

        System.out.println(answer);
    }
}
