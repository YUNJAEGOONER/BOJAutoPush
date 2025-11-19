import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Fire{
        int r;
        int c;
        int m;
        int s;
        int d;
        public Fire(int r, int c, int m, int s,int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int [] dir_r = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dir_c = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []NMK = br.readLine().split(" ");


        int N = Integer.parseInt(NMK[0]);
        int M = Integer.parseInt(NMK[1]);
        int K = Integer.parseInt(NMK[2]);

        List<Fire> fireList = new ArrayList<>();

        for(int i = 0 ; i  < M ; i ++){
            String [] fires = br.readLine().split(" ");
            int r = Integer.parseInt(fires[0]) - 1;
            int c = Integer.parseInt(fires[1]) - 1;
            int m = Integer.parseInt(fires[2]);
            int s = Integer.parseInt(fires[3]);
            int d = Integer.parseInt(fires[4]);
            fireList.add(new Fire(r, c, m, s, d));
        }

        for(int i = 0 ; i < K ; i ++ ){

            int [][][] mmap = new int [N][N][5];

            int [][] visited = new int[N][N];

            for(int j = 0 ; j < fireList.size() ; j ++ ){

                int r = fireList.get(j).r;
                int c = fireList.get(j).c;

                int m = fireList.get(j).m;
                int s = fireList.get(j).s;
                int d = fireList.get(j).d;

                r += (s * dir_r[d]);
                c += (s * dir_c[d]);

                r %= N;
                c %= N;

                if(r < 0){
                    r += N;
                }

                if(c < 0){
                    c += N;
                }

                mmap[r][c][0] += m; // 질량
                mmap[r][c][1] += s; // 속력
                mmap[r][c][2] = d;

                mmap[r][c][3] ++; //갯수

                if(d % 2 == 0){
                    mmap[r][c][4] ++; //짝수
                }
                else{
                    mmap[r][c][4] --; //홀수
                }

                visited[r][c] = 1;

            }

            fireList.clear();

            for(int j = 0 ; j < N ; j ++ ){
                for(int k = 0 ; k < N ; k ++ ){
                    if(visited[j][k] == 1){
                        if(mmap[j][k][3] == 1 && mmap[j][k][0] != 0){
                            fireList.add(new Fire(j, k, mmap[j][k][0], mmap[j][k][1], mmap[j][k][2]));
                            //System.out.print("j = " + j + " k = " + k + "m = " + mmap[j][k][0]);
                        }
                        else{
                            int m = (int)Math.floor((double)mmap[j][k][0]/5);
                            int s = (int)Math.floor((double) mmap[j][k][1] / mmap[j][k][3]);
                            if(m != 0){
                                if(mmap[j][k][3] == Math.abs(mmap[j][k][4])){
                                    fireList.add(new Fire(j, k, m, s, 0));
                                    fireList.add(new Fire(j, k, m, s, 2));
                                    fireList.add(new Fire(j, k, m, s, 4));
                                    fireList.add(new Fire(j, k, m, s, 6));
                                }
                                else{
                                    fireList.add(new Fire(j, k, m, s, 1));
                                    fireList.add(new Fire(j, k, m, s, 3));
                                    fireList.add(new Fire(j, k, m, s, 5));
                                    fireList.add(new Fire(j, k, m, s, 7));
                                }
                            }


                        }
                    }
                }
            }

        }

        int answer = 0;
        for(int i = 0 ; i < fireList.size() ; i ++ ){
            answer += fireList.get(i).m;
        }
        System.out.print(answer);

    }
}
