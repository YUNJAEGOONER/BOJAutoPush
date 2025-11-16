import java.util.*;
import java.io.*;

public class Solution {

    static int max;

    static boolean[] visited;

    static char [] nums;

    static Set<String> cSet = new HashSet<>();

    static Set<String> tempSet = new HashSet<>();


    public static void bt(int start, List<Integer> temp) {
        if(temp.size() == 2) {
            int a = temp.get(0);
            int b = temp.get(1);

            char [] temp_num = nums.clone();

            char temp_c = temp_num[a];
            temp_num[a] = temp_num[b];
            temp_num[b] = temp_c;

            String arrString = String.valueOf(temp_num);

            tempSet.add(arrString);

            return;
        }
        for(int i = start ; i < nums.length ; i ++ ) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(i);
                bt(i + 1, temp);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test ; t ++ ) {
            String[] input = br.readLine().split(" ");

            String num = input[0];
            int n = Integer.parseInt(input[1]);

            cSet = new HashSet<>();

            cSet.add(num);
            max = 0;

            for(int i = 0 ; i < n ; i ++ ) {
                for(String cur : cSet) {
                    nums = new char[cur.length()];
                    visited = new boolean[cur.length()];
                    for(int j = 0 ; j < cur.length() ; j ++ ) {
                        nums[j] = cur.charAt(j);
                    }
                    List<Integer> temp = new ArrayList<Integer>();
                    bt(0, temp);
                }

                cSet.clear();
                cSet.addAll(tempSet);
                tempSet.clear();

            }

            for(String element : cSet) {
                if (max < Integer.parseInt(element)) {
                    max = Integer.parseInt(element);
                }
            }

            System.out.println("#" + (t + 1) + " " + max);
            cSet.clear();
        }

    }

}