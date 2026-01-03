import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test ; t ++ ) {
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            String[] A = br.readLine().split(" ");
            String[] B = br.readLine().split(" ");
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();

            if (N >= M) {
                for (int i = 0; i < A.length; i++) {
                    arr1.add(Integer.parseInt(A[i]));
                }
                for (int i = 0; i < B.length; i++) {
                    arr2.add(Integer.parseInt(B[i]));
                }
            } else {
                for (int i = 0; i < A.length; i++) {
                    arr2.add(Integer.parseInt(A[i]));
                }
                for (int i = 0; i < B.length; i++) {
                    arr1.add(Integer.parseInt(B[i]));
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr1.size() - arr2.size() + 1; i++) {
                int sum = 0;
                for (int j = 0; j < arr2.size(); j++) {
                    sum += (arr1.get(j + i) * arr2.get(j));
                }
                if (max < sum) {
                    max = sum;
                }
            }

            System.out.println("#" + (t + 1) + " " + max);
        }
    }

}