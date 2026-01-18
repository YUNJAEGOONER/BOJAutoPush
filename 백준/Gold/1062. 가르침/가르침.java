import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    static int answer;
    static int k;
    static boolean [] visited;
    static List<String> words;

    public static void bt(int start, int depth){
        if(depth == k){
            int cnt = 0;
            for(int i = 0 ; i < words.size() ; i ++ ){
                String word = words.get(i);
                for(int j = 0 ; j < word.length() ; j ++ ){
                    if(!visited[word.charAt(j) - 'a']){
                        cnt ++;
                        break;
                    }
                }
            }
            answer = Math.max(answer, words.size() - cnt);
        }

        for(int i = start ; i < 26 ; i ++){
            if(!visited[i]){
                visited[i] = true;
                bt(i, depth + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NK = br.readLine().split(" ");

        int n = Integer.parseInt(NK[0]);
        k = Integer.parseInt(NK[1]); // K개의 글자만을 알 수 있음

        words = new ArrayList<>();
        visited = new boolean[26];

        for(int i = 0 ; i < n ; i ++ ){
            String input = br.readLine();
            String word = input.substring(4, input.length() - 4);
            words.add(word);
        }

        answer = 0;
        if(k < 5){
            System.out.print(answer);
        }
        else{
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;
            bt(0, 5);
            System.out.print(answer);
        }
        
    }
}
