import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Main {

    static int [][] mmap;

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        mmap = new int[N][M];

        HashMap<String, Integer> cntMap = new HashMap<>();

        //램프의 상태가 주어짐
        for(int i = 0 ; i < N ; i ++ ){
            String input = br.readLine();
            if(!cntMap.containsKey(input)){
                cntMap.put(input, 0);
            }
            int cnt = cntMap.get(input);
            cntMap.put(input, cnt + 1);
        }

        int K = Integer.parseInt(br.readLine());

        for(String key : cntMap.keySet()){

            int count = 0; // 몇개를 킬건지
            for(int i = 0 ; i < key.length() ; i ++ ){
                if(key.charAt(i) == '0'){
                    count ++ ;
                }
            }

            if(count <= K){
                int remain = count - K;
                if(remain % 2 == 0){
                    answer = Math.max(answer, cntMap.get(key));
                }
            }

        }

        System.out.println(answer);


    }
}
