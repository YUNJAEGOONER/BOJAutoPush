import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> mq = new LinkedList<>();
        for(int i = 1 ; i <= n ; i ++ ){
            mq.add(i);
        }

        while(mq.size() != 1){
            mq.poll();
            int e = mq.poll();
            mq.add(e);
        }

        System.out.println(mq.poll());

    }
}
