import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int [][] fixed = new int [4][8];
    static int [][] mmap = new int [4][8];

    public static void rotate(int dir, int row){
        int [] temp = new int[8];
        if(dir == 1){
            for(int j = 0; j < 7 ; j ++ ){
                temp[j + 1] = fixed[row][j];
            }
            temp[0] = fixed[row][7];
        }
        else{
            for(int j = 7; j > 0 ; j -- ){
                temp[j - 1] = fixed[row][j];
            }
            temp[7] = fixed[row][0];
        }
        mmap[row] = temp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0 ; i < 4 ; i ++ ){
            String line = br.readLine();
            for(int j = 0 ; j < line.length() ; j ++ ){
                mmap[i][j] = line.charAt(j) - '0';
                fixed[i][j] = line.charAt(j) - '0';
            }
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i ++){
            String [] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]) - 1;
            int dir = Integer.parseInt(input[1]);

            //my-self
            rotate(dir, num);

            //left
            int dir_left = dir;
            for(int j = num - 1; j > -1 ; j -- ){
                if(fixed[j][2] == fixed[j + 1][6]) break;
                else{
                    if(dir_left == 1){
                        dir_left = 0;
                        rotate(dir_left, j);
                    }
                    else{
                        dir_left = 1;
                        rotate(dir_left, j);
                    }
                }
            }

            //right
            int dir_right = dir;
            for(int j = num + 1 ; j < 4 ; j ++ ) {
                if (fixed[j - 1][2] == fixed[j][6]) break;
                else {
                    if (dir_right == 1) {
                        dir_right = 0;
                        rotate(dir_right, j);
                    }
                    else{
                        dir_right = 1;
                        rotate(dir_right, j);
                    }
                }
            }

            for(int j = 0; j < fixed.length ; j ++ ){
                fixed[j] = mmap[j].clone();
            }

        }

        int sum = 0;
        for(int i = 0 ; i < 4 ; i ++ ){
            if(mmap[i][0] == 1) sum += (int) Math.pow(2.0, i);
        }

        System.out.println(sum);

    }

}