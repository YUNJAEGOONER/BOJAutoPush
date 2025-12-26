import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String [] arr = br.readLine().split(" ");
        int [] input = new int[N];

        for(int i = 0 ; i < N ; i ++ ){
            input[i] = Integer.parseInt(arr[i]);
        }

        Map<Integer, Integer> mmap = new HashMap<>();

        int max = -1;
        int start = 0;

        for(int i = 0 ; i < N ; i ++ ){

            if(mmap.get(input[i]) == null) {
                mmap.put(input[i], 1);
            }
            else{
                mmap.put(input[i], mmap.get(input[i]) + 1);
                if(mmap.get(input[i]) > K){
                    while (true){
                        mmap.put(input[start], mmap.get(input[start]) - 1);
                        start++;
                        if(input[start - 1] == input[i]){
                            break;
                        }
                    }
                }
            }
            
            if(max < (i - start) + 1){
                max = (i - start) + 1;
            }
        }

        System.out.print(max);

    }

}
