#include <iostream>
#include <vector>
using namespace std;


int main(){

    int n;
    cin >> n;
    while(n--){
        int M, N, K;
        cin >> M >> N >> K;

        vector<int> check;
        int matrix[N][M];
        int visit[N][M];
        for(int i = 0; i  < N; i ++ ){
            for(int j = 0; j < M ; j ++) {
                matrix[i][j] = 0;
                visit[i][j] = 0;
            }
        }

        int size = K;
        int result = 0;

        int my_cabbage = K;

        while(K){
            int i, j;
            cin >> i >> j;
            matrix[j][i] = 1;
            check.push_back((j * M) + i);
            K--;
        }

        while(my_cabbage != 0){
            int x, y;
            vector<vector<int>>mystack;
            for(int i = 0 ; i < size; i ++ ){
                x = check[i] / M;
                y = check[i] % M;
                if(visit[x][y] == 0) {
                    vector<int> start;
                    start.push_back(x);
                    start.push_back(y);
                    visit[x][y] = 1;
                    mystack.push_back(start);
                    my_cabbage--;
                    while (!mystack.empty()){
                        if (0 <= (x - 1) and (x - 1) < N and matrix[x - 1][y] == 1 and visit[x - 1][y] == 0) {
                            vector<int> push;
                            push.push_back(x - 1);
                            push.push_back(y);
                            mystack.push_back(push);
                            x = x - 1;
                            visit[x][y] = 1;
                            my_cabbage--;
                        }
                        //East
                        else if (0 <= (y + 1) and (y + 1) < M and matrix[x][y + 1] == 1 and visit[x][y + 1] == 0) {
                            vector<int> push;
                            push.push_back(x);
                            push.push_back(y + 1);
                            mystack.push_back(push);
                            y = y + 1;
                            visit[x][y] = 1;
                            my_cabbage--;
                        }
                        //South
                        else if (0 <= (x + 1) and (x + 1) < N and matrix[x + 1][y] == 1 and visit[x + 1][y] == 0) {
                            vector<int> push;
                            push.push_back(x + 1);
                            push.push_back(y);
                            mystack.push_back(push);
                            x = x + 1;
                            visit[x][y] = 1;
                            my_cabbage--;
                        }
                        //West
                        else if (0 <= (y - 1) and (y - 1) < M and matrix[x][y - 1] == 1 and visit[x][y - 1] == 0) {
                            vector<int> push;
                            push.push_back(x);
                            push.push_back(y - 1);
                            mystack.push_back(push);
                            y = y - 1;
                            visit[x][y] = 1;
                            my_cabbage--;
                        }
                        else{
                            x = (*(mystack.end() - 1))[0];
                            y = (*(mystack.end() - 1))[1];
                            //North X, East X, South X, West X -> pop
                            if(!(0 <= (x - 1) and (x - 1) < N and matrix[x - 1][y] == 1 and visit[x - 1][y] == 0) and
                                    !(0 <= (y + 1) and (y + 1) < M and matrix[x][y + 1] == 1 and visit[x][y + 1] == 0) and
                                    !(0 <= (x + 1) and (x + 1) < N and matrix[x + 1][y] == 1 and visit[x + 1][y] == 0) and
                                    !(0 <= (y - 1) and (y - 1) < M and matrix[x][y - 1] == 1 and visit[x][y - 1] == 0)){
                                mystack.erase(mystack.end() - 1);
                            }

                        }
                    }

                    result++;
                }
            }
        }

        cout << result << '\n';
    }

}