import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int [][] mmap;

    static String answer;

    static boolean [][] garo;
    static boolean [][] sero;
    static boolean [][] box;

    public static void printMap(){
        for(int i = 0 ; i < 9; i ++ ){
            for(int j = 0 ; j < 9 ; j ++){
                System.out.print(mmap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void getAnswer(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 9; i ++ ){
            for(int j = 0 ; j < 9 ; j ++){
                sb.append(mmap[i][j]);
            }
            sb.append('\n');
        }

        if(answer == null || answer.compareTo(sb.toString()) > 0){
            answer = sb.toString();
        }
    }

    public static void bt(int idx, int cnt){
        if(cnt == 0){
            getAnswer();
            return;
        }
        for(int i = idx ; i < 9 ; i ++ ){
            for(int j = 0 ; j < 9 ; j ++ ){
                if(mmap[i][j] == 0){
                    for(int k = 0 ; k < 9 ; k ++){
                        if(!garo[j][k] && !sero[i][k]){
                            int bnum = (i / 3) * 3 + (j / 3);
                            if(!box[bnum][k]){
                                mmap[i][j] = k + 1;
                                garo[j][k] = true;
                                sero[i][k] = true;
                                box[bnum][k] = true;
                                if(answer != null){
                                    return;
                                }
                                bt(i, cnt - 1);
                                box[bnum][k] = false;
                                garo[j][k] = false;
                                sero[i][k] = false;
                                mmap[i][j] = 0;
                            }
                        }
                    }
                    return; //하나도 값을 채워넣지 못한 경우
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mmap = new int [9][9];
        garo = new boolean [9][10];
        sero = new boolean [9][10];
        box = new boolean [9][10];
        int cnt = 0;

        for(int i = 0 ; i < 9 ; i ++ ){
            String input = br.readLine();
            for(int j = 0 ; j < input.length() ; j ++){
                int element = input.charAt(j) - '0';
                if(element != 0){
                    mmap[i][j] = element;
                    sero[i][element - 1] = true;
                    garo[j][element - 1] = true;
                    int bnum = (i / 3) * 3 + (j / 3);
                    box[bnum][element - 1] = true;
                }
                else{
                    cnt ++;
                }
            }
        }
        bt(0, cnt);
        System.out.print(answer);
    }
}
