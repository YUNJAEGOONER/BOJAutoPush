import java.io.*;

public class Main {

    public static boolean checkBingo(char start){

        //가로 방향
        for(int i = 0 ; i < 3 ; i ++ ){
            for(int j = 0 ; j < 3 ; j ++ ){
                if(start != mmap[i][j]){
                    break;
                }
                if(j == 2){
                    return true;
                }
            }
        }

        //세로 방향
        for(int j = 0 ; j < 3 ; j ++ ){
            for(int i = 0 ; i < 3 ; i ++ ){
                if(start != mmap[i][j]){
                    break;
                }
                if(i == 2){
                    return true;
                }
            }
        }

        //대각선
        for(int i = 0 ; i < 3 ; i ++ ){
            if(start != mmap[i][i]){
                break;
            }
            if(i == 2){
                return true;
            }
        }

        for(int i = 0 ; i < 3 ; i ++ ){
            if(start != mmap[i][2 - i]){
                break;
            }
            if(i == 2){
                return true;
            }
        }

        return false;

    }

    static char [][] mmap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String input = br.readLine();

            if (input.equals("end")) {
                break;
            } else {

                // 최종 상태 조건 (valid)
                // 1. 보드가 꽉 채워졌는데 빙고가 없는 경우
                // 2. 가로, 세로, 대각선에 하나의 빙고가 존재하는 경우

                mmap = new char[3][3];

                int x = 0;
                int o = 0;

                for(int i = 0 ; i < input.length() ; i ++ ){
                    int idx = i / 3;
                    int jdx = i % 3;
                    mmap[idx][jdx] = input.charAt(i);
                    if(mmap[idx][jdx] == 'X'){
                        x ++;
                    }
                    else if(mmap[idx][jdx] == 'O'){
                        o ++;
                    }
                }

                if(x + o == 9){
                    if(x == 5 && o == 4){
                        // 더블 빙고 존재 가능
                        // o가 빙고인 경우는 존재하면 안됨 (이미 게임이 끝나야함)
                        if(checkBingo('O')){
                            System.out.println("invalid");
                        }
                        else{
                            System.out.println("valid");
                        }
                    }
                    else{
                        System.out.println("invalid");
                    }
                }
                else{
                    if(x <= 5 && o <= 4 && (x == o || x - 1 ==o)){
                        if(x == o){
                            //x에서는 빙고가 없고, o에서는 빙고가 있어야함
                            if(checkBingo('O') && !checkBingo('X')){
                                System.out.println("valid");
                            }
                            else{
                                System.out.println("invalid");
                            }
                        }
                        else{
                            //x에서만 빙고가 존재하고, o가 빙고인 경우가 존재해서는 안됨
                            //더블 빙고는 걱정 x (개수가 부족함)
                            if(checkBingo('X') && !checkBingo('O')){
                                System.out.println("valid");
                            }
                            else{
                                System.out.println("invalid");
                            }
                        }
                    }
                    else{
                        System.out.println("invalid");
                    }
                }

            }

        }

    }

}

