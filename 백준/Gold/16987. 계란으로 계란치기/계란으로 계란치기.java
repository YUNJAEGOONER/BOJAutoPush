import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static class Pair{
        int x; // 내구도
        int y; // 무게
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Pair [] arr;

    static int max = 0;

    public static void bt(int cur){

        if(cur == arr.length) { //직전이 가장 오른쪽에 있는 계란인 경우
            return;
        }

        if(arr[cur].x <= 0){ //해당 차례의 계란이 이미 깨져있는 경우
            bt(cur + 1);
        }

        if(arr[cur].x > 0){
            for(int i = 0 ; i < arr.length; i ++ ){
                if(i != cur && arr[cur].x > 0 && arr[i].x > 0){
                    arr[cur].x -= arr[i].y;
                    arr[i].x -= arr[cur].y;
                    int cnt = 0;
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j].x <= 0)
                            cnt++;
                    }
                    if (max < cnt){
                        max = cnt;
                    }
                    bt(cur + 1);
                    arr[cur].x += arr[i].y;
                    arr[i].x += arr[cur].y;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new Pair[n];

        for(int i = 0 ; i < n ; i ++ ){
            String ab [] = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            arr[i] = new Pair(a, b);
        }

        bt(0); //가장 왼쪽을 든다.
        System.out.println(max);
        
    }
}
