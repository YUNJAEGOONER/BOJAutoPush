import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int [][] mmap;

    public static class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair){
            if(pair.y == this.y){
                return this.x - pair.x;
            }
            else{
                return this.y - pair.y;
            }
        }

    }

    public static int r(int sero, int garo){
        int max = garo;

        for(int i = 0 ; i < sero ; i ++){
            HashMap<Integer, Pair> cntMap = new HashMap<>();

            for(int j = 0 ; j < garo ; j ++){
                if(mmap[i][j] != 0){
                    int v = mmap[i][j];
                    if(cntMap.get(v) == null){
                        cntMap.put(v, new Pair(v, 0));
                    }
                    cntMap.get(v).y ++;
                }
            }

            for(int j = 0 ; j < garo ; j ++ ){
                mmap[i][j] = 0;
            }

            List<Pair> pairList = new ArrayList<>(cntMap.values());
            Collections.sort(pairList);

            int jdx = 0;
            for(Pair pair : pairList){
                mmap[i][jdx] = pair.x;
                mmap[i][jdx + 1] = pair.y;
                jdx += 2;
                if(jdx == 100){
                    break;
                }
            }

            if(max <= jdx){
                max = jdx;
            }
        }

        for(int i = 0 ; i < sero ; i ++ ){
            for(int j = 0 ; j < max ; j ++ ){
                if(mmap[i][j] == -1){
                    mmap[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static int c(int sero, int garo){
        int max = sero;

        for(int j = 0 ; j < garo ; j ++){

            HashMap<Integer, Pair> cntMap = new HashMap<>();

            for(int i = 0 ; i < sero ; i ++){
                if(mmap[i][j] != 0){
                    int v = mmap[i][j];
                    if(cntMap.get(v) == null){
                        cntMap.put(v, new Pair(v, 0));
                    }
                    cntMap.get(v).y ++;
                }
            }

            for(int i = 0 ; i < sero ; i ++ ){
                mmap[i][j] = 0;
            }

            List<Pair> keys = new ArrayList<>(cntMap.values());
            Collections.sort(keys);

            int idx = 0;
            for(Pair pair: keys){
                mmap[idx][j] = pair.x;
                mmap[idx + 1][j] = pair.y;
                idx += 2;
                if(idx == 100){
                    break;
                }
            }

            if(max <= idx){
                max = idx;
            }
        }

        for(int j = 0 ; j < garo ; j ++ ){
            for(int i = 0 ; i < max ; i ++ ){
                if(mmap[i][j] == -1){
                    mmap[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void printMap(){
        for(int i = 0 ; i < 101 ; i ++ ){
            for(int j = 0 ; j < 101; j ++){
                System.out.print(mmap[i][j] + "");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] rck = br.readLine().split(" ");

        int r = Integer.parseInt(rck[0]);
        int c = Integer.parseInt(rck[1]);
        int k = Integer.parseInt(rck[2]);

        int answer = -1;

        mmap = new int[101][101];

        for(int i = 0 ; i < 3 ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < 3 ; j ++){
                mmap[i][j] = Integer.parseInt(input[j]);
            }
        }

        int garo = 3;
        int sero = 3;
        int cnt = 0;

        while (cnt < 101){

            if(mmap[r - 1][c - 1] == k){
                answer = cnt;
                break;
            }

            if(garo <= sero){
                //R연산
                garo = r(sero, garo);
            }
            else{
                //C연산
                sero = c(sero, garo);
            }
            cnt++;
        }

        System.out.println(answer);






    }

}
