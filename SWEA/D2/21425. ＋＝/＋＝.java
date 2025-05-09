import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i ++ ){

            int A, B, N;
            A = sc.nextInt();
            B = sc.nextInt();
            N = sc.nextInt();
            int cnt = 0;

            while(true){
                if(A > N || B > N) break;
                if(A > B) B += A;
                else A += B;
                cnt ++;
                //System.out.println("A = " + A + " B = " + B);
            }
            System.out.println(cnt);
        }
    }
}
