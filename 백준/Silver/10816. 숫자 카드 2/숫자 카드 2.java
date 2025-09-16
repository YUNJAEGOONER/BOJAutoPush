import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    static int answer = 0;

    static List<Integer> list = new ArrayList<>();

    public static void binarySearch(int s, int e, int t) {
        if (s > e) {
            return;
        }

        int mid = (s + e) / 2;

        if (list.get(mid) == t) {
            answer = 1;
            return;
        }

        if (t > list.get(mid)) {
            binarySearch(mid + 1, e, t);
        } else {
            binarySearch(s, mid - 1, t);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int element = Integer.parseInt(arr[i]);
            if (hmap.get(element) != null) {
                int value = hmap.get(element) + 1;
                hmap.put(element, value);
            } else {
                hmap.put(element, 1);
            }
        }

        list = hmap.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        int m = Integer.parseInt(br.readLine());
        String[] card = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            answer = 0;
            int target = Integer.parseInt(card[i]);
            binarySearch(0, list.size() - 1, target);
            if (answer == 1) {
                sb.append(hmap.get(target));
            } else {
                sb.append('0');
            }
            sb.append(' ');
        }

        System.out.println(sb.toString());


    }

}
