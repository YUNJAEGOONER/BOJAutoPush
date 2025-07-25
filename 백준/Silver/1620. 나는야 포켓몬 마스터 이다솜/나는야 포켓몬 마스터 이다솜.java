import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, String> mmap = new HashMap<>();

        for(int i = 0 ; i < N ; i ++ ){
            String pokemon = sc.next();
            String num = Integer.toString(i + 1);
            mmap.put(pokemon, num);
            mmap.put(num, pokemon);
        }

        for(int i = 0 ; i < M ; i ++ ){
            String quiz = sc.next();
            System.out.println(mmap.get(quiz));
        }
    }
}