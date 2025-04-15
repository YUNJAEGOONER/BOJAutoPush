import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int [] intArr = new int[N];

        for (int i = 0; i < N; i++){
            intArr[i] = i + 1;
        }

        while(M-- != 0){
            int s, e;
            s = sc.nextInt(); // s - 1
            e = sc.nextInt(); //e - 1
            int cnt = (e - s + 1) / 2;
            for(int i = 0; i < cnt; i ++){
                int temp = intArr[(s - 1) + i];
                intArr[(s - 1) + i] = intArr[(e - 1) - i];
                intArr[(e - 1) - i] = temp;
            }
        }

        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i] + " ");
        }
    }
}
