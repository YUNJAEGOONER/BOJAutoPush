import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static int [][] mmap;

    static boolean [] visited;

    static int count;

    static boolean [] tVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test ; t ++){
            int N = Integer.parseInt(br.readLine());
            String [] input = br.readLine().split(" ");

            count = 0;

            visited = new boolean[N];
            mmap = new int[N][1];

            for(int i = 0 ; i < N ; i ++ ){
                int pair = Integer.parseInt(input[i]) - 1;
                mmap[i][0] = pair;
            }

            tVisited = new boolean[N];

            for(int i = 0 ; i < N ; i ++){
                if(!visited[i]){
                    Stack<Integer> stk = new Stack<>();
                    stk.push(i);
                    tVisited[i] = true;

                    while(!stk.isEmpty()){
                        int friend = mmap[stk.peek()][0];

                        //싸이클이 발생
                        if(tVisited[friend]){
                            while (true){
                                int top = stk.pop();
                                visited[top] = true;
                                tVisited[top] = false;
                                count ++;
                                if(top == friend){
                                    break;
                                }
                            }
                            while (!stk.isEmpty()){
                                tVisited[stk.pop()] = false;
                            }
                        }

                        else if(!visited[friend]){
                            stk.add(friend);
                            tVisited[friend] = true;
                        }

                        else{
                            while (!stk.isEmpty()){
                                int top = stk.pop();
                                tVisited[top] = false;
                                visited[top] = true;
                            }
                            break;
                        }

                    }
                }
            }

            System.out.println(N - count);
        }
    }

}
