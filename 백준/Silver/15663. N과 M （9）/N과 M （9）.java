import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int [] arr;
    static int [] visited;
    static int tdepth;

    static Set<String> answer = new LinkedHashSet<>();

    public static void bt(int depth, List<String> temp){
        if(depth == tdepth){
            StringBuilder sb = new StringBuilder();
            temp.stream().forEach(str -> sb.append(str + " "));
            //System.out.println(sb);
            answer.add(sb.toString());
            return;
        }
        for(int i = 0 ; i < arr.length ; i ++ ){
            if(visited[i] == 0){
                visited[i] = 1;
                temp.add(String.valueOf(arr[i]));
                bt(depth + 1, temp);
                temp.remove(temp.size() - 1);
                visited[i] = 0;
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        tdepth = Integer.parseInt(NM[1]);

        String[] inputs = br.readLine().split(" ");

        arr = new int[N];
        for(int i = 0 ; i < inputs.length ; i ++){
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(arr);
        visited = new int[N];

        List<String> temp = new ArrayList<>();
        bt(0, temp);

        for (String s : answer) {
            System.out.println(s);
        }

    }

}
