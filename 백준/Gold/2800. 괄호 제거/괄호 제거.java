import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static List<Pair> pairList;

    static boolean [] removed;

    static Set<String> answer;

    static String input;

    public static void bt(int start, boolean check){

        if(check){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < input.length() ; i ++){
                if(!removed[i]){
                    sb.append(input.charAt(i));
                }
            }
            answer.add(sb.toString());
        }

        for(int i = start ; i < pairList.size() ; i ++ ){
            Pair pair = pairList.get(i);
            removed[pair.x] = true;
            removed[pair.y] = true;
            bt(i + 1, true);
            removed[pair.x] = false;
            removed[pair.y] = false;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        Stack<Integer> stk = new Stack<>();

        pairList = new ArrayList<>();
        answer = new HashSet<>();
        removed = new boolean[input.length()];

        for(int i = 0 ; i < input.length() ; i ++ ) {
            if(input.charAt(i) == '('){
                stk.push(i);
            }
            else if(input.charAt(i) == ')'){
                int a = i;
                int b = stk.pop();
                pairList.add(new Pair(b, a));
            }
        }

        if(stk.empty()){
            bt(0, false);
            List<String> answerList = new ArrayList<>(answer);
            Collections.sort(answerList);
            for(String a : answerList){
                System.out.println(a);
            }
        }


    }
}
