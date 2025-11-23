import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] MD = br.readLine().split(" ");

        int monkey = Integer.parseInt(MD[0]);
        int dog = Integer.parseInt(MD[1]);

        int remainder = dog - monkey;
        int a = 1;

        int day = 0;
        while(remainder > 0){
            if(remainder <= a){
                day ++;
                remainder = 0;
            }
            else {
                if (remainder - 2 * a >= 0) {
                    remainder -= 2 * a;
                    a ++;
                    day += 2;
                }
                else {
                    remainder -= a;
                    a ++;
                    day += 1;
                }
            }
        }

        System.out.println(day);
    }

}
