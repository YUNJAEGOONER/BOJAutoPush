import java.util.Scanner;

public class Main {
    public static void main(String args[]){
//        System.out.println("Hello world");

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char [][] cookies = new char[n][n];
        sc.nextLine();

        for(int i = 0; i < n ; i ++ ){
            String line = sc.nextLine();
            for(int j = 0 ; j < n ; j ++ ){
                cookies[i][j] = line.charAt(j);
            }
        }

        boolean head = true;
        int h_x = 0;
        int h_y = 0;

        for(int i = 0 ; i <  n ; i ++ ){
            for(int j = 0 ; j < n ; j ++ ){
                if(cookies[i][j] == '*' && head){
                    head = false;
                    h_x = i;
                    h_y = j;
                }
            }
        }
        h_x += 1;

        //get_left_
        int left = 0;
        for(int j = h_y - 1 ; j > -1 ; j -- ){
            if(cookies[h_x][j] == '*'){
                left ++;
            }
        }

        int right = 0;
        for(int j = h_y + 1 ; j < n ; j ++ ){
            if(cookies[h_x][j] == '*'){
                right ++;
            }
        }

        int end = 0;
        for(int i = h_x + 1 ; i < n ; i ++ ){
            if(cookies[i][h_y] == '*'){
                end ++;
            }
        }

        int left_leg = 0;
        for(int i = h_x + end + 1 ; i < n ; i ++ ){
            if(cookies[i][h_y - 1] == '*'){
                left_leg ++;
            }
        }

        int right_leg = 0;
        for(int i = h_x + end + 1 ; i < n ; i ++ ){
            if(cookies[i][h_y + 1] == '*'){
                right_leg ++;
            }
        }


        System.out.println((h_x + 1) + " " + (h_y + 1));
        System.out.println(left + " " + right + " " + end + " " + left_leg + " " + right_leg);

    }
}
