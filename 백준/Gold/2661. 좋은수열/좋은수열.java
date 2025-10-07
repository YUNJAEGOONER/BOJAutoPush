import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean found = false;

    public static boolean check(List<Integer> temp){

        StringBuilder sb = new StringBuilder();
        for (Integer i : temp) {
            sb.append(i);
        }

        for(int i = 1 ; i <= sb.length() / 2 ; i ++ ){
            for(int j = 0 ; j <= sb.length() - (2 * i) ; j ++ ){
                String sub1 = sb.substring(j, j + i);
                String sub2 = sb.substring(j + i, j + i + i);
                if(sub1.equals(sub2)) return false;
            }
        }
        return true;
    }

    public static void bt(int depth, List<Integer> temp){
        if(depth == n){
            for (Integer i : temp) {
                System.out.print(i);
            }
            found = true;
            return;
        }
        for(int i = 1 ; i < 4 ; i ++ ){
            temp.add(i);
            if(found) return;
            if(check(temp)){
                bt(depth + 1, temp);
            }
            temp.remove(temp.size() - 1);
        }
    }

    static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        bt(1, list);
    }

}
