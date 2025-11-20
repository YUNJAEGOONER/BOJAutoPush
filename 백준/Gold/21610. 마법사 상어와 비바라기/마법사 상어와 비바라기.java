import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Main {

    static int [] dir_x = {0, -1, -1, -1, 0, 1, 1, 1};
    static int [] dir_y = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static class Cloud{
        int x;
        int y;

        public Cloud(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Cloud){
                Cloud cloud = (Cloud) obj;
                return (cloud.x == this.x && cloud.y == this.y);
            }
            return false;
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.x, this.y);
        }

    }



    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] MN = br.readLine().split(" ");

        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        int [][] mmap = new int[M][M];
        for(int i = 0 ; i < M ; i ++ ){
            String [] input = br.readLine().split(" ");
            for(int j = 0 ; j < input.length ; j ++ ){
                mmap[i][j] = Integer.parseInt(input[j]);
            }
        }

        List<Cloud> cloudList = new ArrayList<>();
        cloudList.add(new Cloud(M - 1, 0));
        cloudList.add(new Cloud(M - 1, 1));
        cloudList.add(new Cloud(M - 2, 0));
        cloudList.add(new Cloud(M - 2, 1));


        for(int t = 0 ; t < N ; t ++ ){

            String [] DS = br.readLine().split(" ");

            int D = Integer.parseInt(DS[0]) - 1;
            int S = Integer.parseInt(DS[1]);

            Set<Cloud> temp = new HashSet<>();

            //구름 이동
            for(Cloud cloud : cloudList){
                int x = cloud.x;
                int y = cloud.y;

                x = (x + (dir_x[D] * S)) % M;
                y = (y + (dir_y[D] * S)) % M;

                if(x < 0){
                    x += M;
                }
                if(y < 0) {
                    y += M;
                }
                temp.add(new Cloud(x, y));
            }

            //구름에서 비가 내림
            for(Cloud cloud : temp){
                mmap[cloud.x][cloud.y] ++;
            }

            //물 복사 버그
            for(Cloud cloud : temp){ //물이 증가한 칸
                int x = cloud.x;
                int y = cloud.y;
                for(int j = 1 ; j < 8 ; j += 2){
                    int temp_x = x + dir_x[j];
                    int temp_y = y + dir_y[j];
                    if((0 <= temp_x && temp_x < M) && (0 <= temp_y && temp_y < M)){
                        if(mmap[temp_x][temp_y] > 0) {
                            mmap[x][y]++;
                        }
                    }
                }
            }

            List<Cloud> newCloud = new ArrayList<>();
            for(int i = 0 ; i < M ; i ++ ){
                for(int j = 0 ; j < M ; j ++ ){
                    if(mmap[i][j] >= 2 && !(temp.contains(new Cloud(i, j)))){
                        newCloud.add(new Cloud(i, j));
                        mmap[i][j] -= 2;
                    }
                }
            }

            cloudList.clear();
            cloudList.addAll(newCloud);

        }

        int answer = 0;
        for(int i = 0 ; i < M ; i ++ ){
            for(int j = 0 ; j < M ; j ++ ){
                answer += mmap[i][j];
            }
        }

        System.out.print(answer);



    }
}
