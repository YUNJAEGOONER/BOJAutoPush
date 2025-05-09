import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
    public static boolean check(String str){
        boolean result = true;
        for(int i = 0 ; i < str.length() / 2 ; i ++ ){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i ++ ){
            String word = sc.next();
            int result = 0;
            if(check(word)){
                result = 1;
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
