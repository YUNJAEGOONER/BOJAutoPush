import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        result.add(answer);

        for(int i = 1 ; i < n ; i ++ ){
            int temp_size = 1;
            int temp_idx = -1;
            for(int j = i - 1 ; j > - 1; j --){
                if(arr[j] < arr[i]){
                    if(result.get(j).size() + 1 > temp_size){
                        temp_idx = j;
                        temp_size = result.get(j).size() + 1;
                    }
                }
            }

            List<Integer> array;
            if(temp_idx == -1){
                array = new ArrayList<>();
                array.add(arr[i]);
            }
            else{
                array = new ArrayList<>(result.get(temp_idx));
                array.add(arr[i]);
            }

            result.add(array);

            if(answer.size() < array.size()){
                answer = array;
            }
        }


        System.out.println(answer.size());
        for (Integer i : answer) {
            System.out.print(i + " ");
        }

    }

}
