import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        String input = br.readLine();

        int answer = 0;
        int cnt = 0;

        for(int i = 0 ; i < input.length() - 1 ; i ++ ){
            if(input.charAt(i) == 'I' && cnt == 0){
                cnt ++;
            }
            else if(cnt != 0 && input.charAt(i) != input.charAt(i + 1)){
                cnt ++;
            }
            else{
                if(cnt > 0){

                    if(input.charAt(i) == 'O'){
                        cnt --;
                    }

                    while (cnt >= 2 * N){
                        answer ++;
                        cnt -= 2;
                    }

                }
                cnt = 0;
            }
        }

        if(cnt > 0){

            if(input.charAt(M - 1) == 'O'){
                cnt --;
            }

            while (cnt >= N * 2){
                answer ++;
                cnt -= 2;
            }

        }

        System.out.println(answer);

    }

}
