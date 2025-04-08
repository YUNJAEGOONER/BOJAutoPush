//
// Created by Yunjae on 2025-04-08.
//
#include<vector>
#include<iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    int r, c, d;
    cin >> r >> c >> d;

    vector<vector<int>> vec;
    for(int i = 0 ; i < N ; i ++) {
        vector<int> row;
        for(int j = 0 ; j < M ; j ++) {
            int e;
            cin >> e;
            row.push_back(e);
        }
        vec.push_back(row);
    }

    //0 : 갈 수 있음 - 1 : 벽
    int cur_x, cur_y, cur_d;

    cur_x = r;
    cur_y = c;
    cur_d = d;
    int answer = 0;


    while(true) {
        //1. 현재 칸이 아직 청소되지 않은 경우
        if(vec[cur_x][cur_y] == 0) {
            vec[cur_x][cur_y] = -1;
            answer ++;
        }

        //청소할게 있는 경우,
        if((cur_x - 1 >= 0 && vec[cur_x - 1][cur_y] == 0) || (cur_x + 1 < N && vec[cur_x + 1][cur_y] == 0) ||
            (cur_y +  1 < M && vec[cur_x][cur_y + 1] == 0) || (cur_y - 1 >= 0 && vec[cur_x][cur_y -1] == 0)) {
            //반시계 방향으로 회전한다.
            cur_d --;
            if(cur_d < 0) cur_d += 4;

            if(cur_d == 0 && (cur_x - 1 >= 0 && vec[cur_x - 1][cur_y] == 0)){ //북
                cur_x --;
            }
            else if(cur_d == 3 && (cur_y - 1 >= 0 && vec[cur_x][cur_y - 1] == 0)) {
                cur_y --;
            }
            else if(cur_d == 2 && (cur_x + 1 < N && vec[cur_x + 1][cur_y] == 0)) {
                cur_x ++;
            }
            else if(cur_d == 1 && (cur_y + 1 < M && vec[cur_x][cur_y + 1] == 0)) {
                cur_y ++;
            }
        }
        else {
            if(cur_d == 0 && (cur_x + 1 < N && vec[cur_x + 1][cur_y] != 1)){ //북
                cur_x ++;
            }
            else if(cur_d == 1 && (cur_y - 1 >= 0 && vec[cur_x][cur_y - 1] != 1)) {
                cur_y --;
            }
            else if(cur_d == 2 && (cur_x - 1 >= 0 && vec[cur_x - 1][cur_y] != 1)) {
                cur_x --;
            }
            else if(cur_d == 3 && (cur_y + 1 < M && vec[cur_x][cur_y + 1] != 1)) {
                cur_y ++;
            }
            else {
                break;
            }
        }

    }
    cout << answer << ' ';
    return 0;
}