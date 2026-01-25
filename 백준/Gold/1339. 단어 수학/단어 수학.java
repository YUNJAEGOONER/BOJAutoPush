import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();

        int [] weight = new int [26];
        int [] toNum = new int [26];

        for(int i = 0 ; i < n ; i ++ ){
            String word = br.readLine();
            for(int j = 0 ; j < word.length() ; j ++ ){
                char cur = word.charAt(j);
                weight[cur - 'A'] += Math.pow(10, word.length() - 1 - j);
            }
            arr.add(word);
        }

        Map<Integer, List<Character>> mmap = new HashMap<>();
        for(int i = 0 ; i < weight.length ; i ++){
            int key = weight[i];
            if(key != 0){
                List<Character> charList = mmap.getOrDefault(key, new ArrayList<>());
                charList.add((char)('A' + i));
                mmap.put(key, charList);
            }
        }

        List<Integer> keyList = new ArrayList<>(mmap.keySet());
        Collections.sort(keyList, Comparator.reverseOrder());

        int num = 9;
        for(Integer key : keyList){
            List<Character> charList = mmap.get(key);
            for(Character c : charList){
                toNum[c - 'A'] = num;
                num --;
            }
        }

        long sum = 0;
        for(int i = 0 ; i < arr.size() ; i ++ ){
            StringBuilder sb = new StringBuilder();
            String word = arr.get(i);
            for(int j = 0 ; j < word.length() ; j ++ ){
                sb.append(toNum[word.charAt(j) - 'A']);
            }
            sum += Long.parseLong(sb.toString());
        }
        System.out.print(sum);

    }
}
