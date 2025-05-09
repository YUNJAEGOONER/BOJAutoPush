import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n ; i ++ ){
            String num = Integer.toString(i);
            boolean flag = true;
            for(int j = 0 ; j < num.length() ; j ++ ){
                if(num.charAt(j) != '0' && (num.charAt(j) - '0') % 3 == 0){
                    System.out.print("-");
                    flag = false;
                }
            }
            if(flag) System.out.print(num);
            System.out.print(" ");
        }
    }
}
