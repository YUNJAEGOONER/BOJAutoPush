//
// Created by Yunjae on 2025-04-10.
//
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int R, C, T;
    cin >> R >> C >> T;

    vector<vector<int>> vec;

    vector<pair<int, int>> machine;

    vector<vector<int>> temp;

    vector<vector<int>> wind;

    for(int i = 0 ; i < R ; i ++ ) {
        vector<int> row;
        for(int j = 0 ; j < C ; j ++ ) {
            int e;
            cin >> e;
            row.push_back(e);
            if(e == -1) {
                machine.push_back(make_pair(i, j));
            }
        }
        vec.push_back(row);
        temp.push_back(vector<int>(C));
    }


    for(int i = 0 ; i < T; i ++ ) {
        //1. 미세먼지가 확산된다.
        vector<vector<int>> dust = temp;
        for(int i = 0 ; i < R ; i ++ ) {
            for(int j = 0 ; j < C ; j ++ ) {
                if(vec[i][j] > 0) {
                    int amount = vec[i][j]/5;
                    int cnt = 0;
                    //상
                    if(i - 1 >= 0 && vec[i - 1][j] != -1) {
                        dust[i - 1][j] += amount;
                        vec[i][j] -= amount;
                    }
                    //하
                    if(i + 1 < R && vec[i + 1][j] != -1) {
                        dust[i + 1][j] += amount;
                        vec[i][j] -= amount;
                    }
                    //좌
                    if(j - 1 >= 0 && vec[i][j - 1] != -1) {
                        dust[i][j - 1] += amount;
                        vec[i][j] -= amount;
                    }
                    //우
                    if(j + 1 < C && vec[i][j + 1] != -1) {
                        dust[i][j + 1] += amount;
                        vec[i][j] -= amount;
                    }
                }
            }
        }

        for(int i = 0 ; i < R ; i ++ ) {
            for(int j = 0 ; j < C ; j ++ ) {
                if(vec[i][j] != -1) {
                    vec[i][j] += dust[i][j];
                }
            }
        }

        wind = vec;
        //2. 공기청정기가 작동한다.
        //2-1 위쪽 공기 청정기(반시계 방향)
        int cur_x = machine[0].first;
        int cur_y = machine[0].second;
        int direction = 1;
        while(true) {
            //우
            if(direction == 1) {
                if(cur_y == C - 1) {
                    wind[cur_x - 1][cur_y] = vec[cur_x][cur_y];
                    cur_x -= 1;
                    direction ++;
                }
                else {
                    if(vec[cur_x][cur_y] != - 1) {
                        wind[cur_x][cur_y + 1] = vec[cur_x][cur_y];
                    }
                    else {
                        wind[cur_x][cur_y + 1] = 0;
                    }
                    cur_y ++;
                }
            }
            //위
             else if(direction == 2) {
                 if(cur_x == 0) {
                     wind[cur_x][cur_y - 1] = vec[cur_x][cur_y];
                     cur_y -= 1;
                     direction ++;
                 }
                 else {
                     wind[cur_x - 1][cur_y] = vec[cur_x][cur_y];
                     cur_x --;
                 }
             }
            //좌
            else if(direction == 3) {
                if(cur_y == 0) {
                    wind[cur_x + 1][cur_y] = vec[cur_x][cur_y];
                    cur_x += 1;
                    direction ++;
                }
                else {
                    wind[cur_x][cur_y - 1] = vec[cur_x][cur_y];
                    cur_y --;
                }
            }
            //아래
            else if(direction == 4) {
                if(vec[cur_x][cur_y] == -1) {
                    wind[cur_x][cur_y] = -1;
                    break;
                }
                wind[cur_x + 1][cur_y] = vec[cur_x][cur_y];
                cur_x ++;
            }
        }

        cur_x = machine[1].first;
        cur_y = machine[1].second;
        direction = 1;
        while(true) {
            //우
            if(direction == 1) {
                if(cur_y == C - 1) {
                    wind[cur_x + 1][cur_y] = vec[cur_x][cur_y];
                    cur_x += 1;
                    direction ++;
                }
                else {
                    if(vec[cur_x][cur_y] != - 1) {
                        wind[cur_x][cur_y + 1] = vec[cur_x][cur_y];
                    }
                    else {
                        wind[cur_x][cur_y + 1] = 0;
                    }
                    cur_y ++;
                }
            }
            //위
            else if(direction == 4) {
                if(vec[cur_x][cur_y] == -1) {
                    wind[cur_x][cur_y] = -1;
                    break;
                }
                wind[cur_x - 1][cur_y] = vec[cur_x][cur_y];
                cur_x --;
            }
            //좌
            else if(direction == 3) {
                if(cur_y == 0) {
                    wind[cur_x - 1][cur_y] = vec[cur_x][cur_y];
                    cur_x -= 1;
                    direction ++;
                }
                else {
                    wind[cur_x][cur_y - 1] = vec[cur_x][cur_y];
                    cur_y --;
                }
            }
            //아래
            else if(direction == 2) {
                if(cur_x == R - 1) {
                    wind[cur_x][cur_y - 1] = vec[cur_x][cur_y];
                    cur_y -= 1;
                    direction ++;
                }
                else {
                    wind[cur_x + 1][cur_y] = vec[cur_x][cur_y];
                    cur_x ++;
                }
            }
        }
        vec = wind;

    }

    int sum = 0;
    for(auto a : wind) {
        for(auto b : a) {
            sum += b;
        }
    }
    cout << (sum + 2);
    return 0;
}