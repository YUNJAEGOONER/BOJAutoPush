//
// Created by Yunjae on 2025-04-08.
//
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, M, x, y, K;
    cin >> N >> M >> x >> y >> K;

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


    int x1 = 0; int x2 = 0; int x3 = 0;
    int x6 = 0; int x5 = 0; int x4 = 0;
    int cur_x = x;
    int cur_y = y;

    for(int i = 0 ; i < K ; i ++) {

        int cmd;
        cin >> cmd;

        bool move = false;
        //동쪽
        if(cmd == 1 && cur_y + 1 < M) {
            int tmp1, tmp2;
            tmp1 = x1; tmp2 = x6;
            x6 = x4; x1 = x3;
            x4 = tmp1; x3 = tmp2;
            cur_y ++;
            move = true;
        }
        //서쪽
        else if(cmd == 2 && cur_y - 1 >= 0) {
            int tmp1, tmp2;
            tmp1 = x1; tmp2 = x6;
            x6 = x3; x1 = x4;
            x4 = tmp2; x3 = tmp1;
            cur_y --;
            move = true;
        }
        //북쪽
        else if(cmd == 3 && cur_x - 1 >= 0) {
            int tmp1, tmp2;
            tmp1 = x1; tmp2 = x6;
            x6 = x5; x1 = x2;
            x5 = tmp1; x2 = tmp2;
            cur_x --;
            move = true;
        }
        else if(cmd == 4 && cur_x + 1 < N) {
            int tmp1, tmp2;
            tmp1 = x1; tmp2 = x6;
            x6 = x2; x1 = x5;
            x5 = tmp2; x2 = tmp1;
            cur_x ++;
            move = true;
        }

        //cout << cur_x << " : " << cur_y << '\n';

        //cout << x1 << ' ' << x2 << ' ' << x3 << ' ' << x4 << ' ' << x5 << ' ' << x6 << ' ' <<'\n';

        //이동한 칸에 쓰여 있는 수가 0이면
        if(move){
            cout << x6 << '\n';
             if(vec[cur_x][cur_y] == 0) {
                 vec[cur_x][cur_y] = x1;
             }
             else {
                 x1 = vec[cur_x][cur_y];
                 vec[cur_x][cur_y] = 0;
             }
        }
    }



    return 0;
}