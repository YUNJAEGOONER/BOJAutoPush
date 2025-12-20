import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    //봄 + 여름
    public static void SpringSummer(){
        for(int i = 0 ; i < N * N ; i ++ ){
            List<Integer> treeList = tree.get(i);
            Collections.sort(treeList); // 어린 나무 부터

            List<Integer> nTreeList = new ArrayList<>();

            int death = 0;
            int idx = i / N;
            int jdx = i % N;

            for(int j = 0 ; j < treeList.size() ; j ++){
                int cur_tree = treeList.get(j);
                if(yangbun[idx][jdx] - cur_tree >= 0) {
                    yangbun[idx][jdx] -= cur_tree;
                    cur_tree ++;
                    nTreeList.add(cur_tree);
                }
                else{
                    death += cur_tree / 2;
                }
            }

            tree.remove(i);
            tree.add(i, nTreeList);
            yangbun[idx][jdx] += death;
        }
    }

    public static void Fall(){
        for(int i = 0 ; i < N * N ; i ++ ){
            List<Integer> treeList = tree.get(i);
            int idx = i / N;
            int jdx = i % N;
            for(int j = 0 ; j < treeList.size() ; j ++ ){
                int cur = treeList.get(j);
                if(cur != 0 && cur % 5 == 0){
                    for(int d = 0 ; d < 8 ; d ++ ){
                        int x = idx + dir_x[d];
                        int y = jdx + dir_y[d];
                        if((0 <= x && x < N) && (0 <= y && y < N)){
                            tree.get(N * x + y).add(1);
                        }
                    }
                }
            }
        }
    }

    public static void Winter(){
        //양분이 추가됨
        for(int i = 0 ; i < A.length ; i ++ ){
            for(int j = 0 ; j < A[0].length ; j ++ ){
                yangbun[i][j] += A[i][j];
            }
        }
    }

    public static int countTrees(){
        int cnt = 0;
        for(int i = 0 ; i < N * N ; i ++ ){
            cnt += tree.get(i).size();
        }
        return cnt;
    }

    static int N;
    static int [][] yangbun;
    static int [][] A;
    static List<List<Integer>> tree;
    static int [] dir_x = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dir_y = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NMK = br.readLine().split(" ");

        N = Integer.parseInt(NMK[0]); //땅
        int M = Integer.parseInt(NMK[1]);
        int K = Integer.parseInt(NMK[2]); //연도

        A = new int[N][N];
        yangbun = new int[N][N];

        for(int i = 0 ; i < N ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++ ){
                A[i][j] = Integer.parseInt(input[j]);
                yangbun[i][j] = 5;
            }
        }

        tree = new ArrayList<>();
        for(int i = 0 ; i < (N * N) ; i ++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i ++ ){
            String [] rct = br.readLine().split(" ");

            int r = Integer.parseInt(rct[0]) - 1;
            int c = Integer.parseInt(rct[1]) - 1;
            int t = Integer.parseInt(rct[2]);

            tree.get(r * N + c).add(t);
        }

        while (K != 0){
            K --;
            SpringSummer();
            Fall();
            Winter();
        }

        int answer = countTrees();
        System.out.print(answer);

    }

}
