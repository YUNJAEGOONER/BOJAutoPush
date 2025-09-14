import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] NL = br.readLine().split(" ");

        int N = Integer.parseInt(NL[0]);
        int L = Integer.parseInt(NL[1]);

        int [][] mmap = new int[N][N];

        for(int i = 0 ; i < N ; i ++ ){
            String [] row = br.readLine().split(" ");
            for(int j = 0 ; j < row.length ; j ++ ){
                mmap[i][j] = Integer.parseInt(row[j]);
            }
        }

        int answer = 0;

        //가로 방향
        for(int i = 0 ; i < N ; i ++ ){
            boolean available = true;
            int [] visited = new int[N]; //중복으로 경사 설치 x

            for(int j = 0 ; j < N - 1; j ++ ){

                int cur = j + 1;
                int prev = j;

                //내리막길
                if (mmap[i][prev] - mmap[i][cur] == 1){
                    int desc = 0;

                    for(int k = 0 ; k < L ; k ++ ){
                        if(cur + k < N && visited[cur + k] == 0 && mmap[i][prev] - mmap[i][cur + k] == 1){
                            desc ++;
                        }
                    }

                    if(desc == L){
                        j = j + (L - 1);
                        for(int k = 0 ; k < L ; k ++ ){
                           visited[cur + k] = 1;
                        }
                    }

                    else{
                        available = false;
                    }

                }

                // 오르막길
                else if (mmap[i][cur] - mmap[i][prev] == 1){
                    int asc = 0;
                    for(int k = cur - L ; k < cur ; k ++ ){
                        if(0 <= k && visited[k] == 0 && mmap[i][k] == mmap[i][cur] - 1){
                            asc ++;
                        }
                    }

                    if(asc == L){
                        for(int k = cur - L ; k < cur ; k ++ ){
                            visited[k] = 1;
                        }
                    }
                    else{
                        available = false;
                    }


                }
                else{
                    if(mmap[i][prev] != mmap[i][cur]){
                        available = false;
                    }
                }
            }

            if(available){
                answer ++;
            }
        }

        //세로 방향
        for(int j = 0 ; j < N ; j ++ ){
            boolean available = true;
            int [] visited = new int[N];

            for(int i = 0 ; i < N - 1; i ++ ){
                int prev = i;
                int cur = i + 1;

                //내리막길
                if (mmap[prev][j] - mmap[cur][j] == 1){
                    int desc = 0;

                    for(int k = 0 ; k < L ; k ++ ){
                        if(cur + k < N && visited[cur + k] == 0 && mmap[prev][j] - mmap[cur + k][j] == 1){
                            desc ++;
                        }
                    }

                    if(desc == L){
                        i = i + (L - 1);
                        for(int k = 0 ; k < L ; k ++ ){
                            visited[cur + k] = 1;
                        }
                    }
                    else{
                        available = false;
                    }
                }

                // 오르막길
                else if (mmap[cur][j] - mmap[prev][j] == 1){
                    int asc = 0;
                    for(int k = cur - L ; k < cur ; k ++ ){
                        if(0 <= k && visited[k] == 0 && mmap[k][j] == mmap[cur][j] - 1){
                            asc ++;
                        }
                    }
                    if(asc == L){
                        for(int k = cur - L ; k < cur ; k ++ ){
                            visited[k] = 1;
                        }
                    }
                    else{
                        available = false;
                    }

                }
                else{
                    //같은 길
                    if(mmap[prev][j] != mmap[cur][j]){
                        available = false;
                        break;
                    }

                }
            }
            if(available){
                answer ++;
            }
        }

        System.out.println(answer);



    }

}
