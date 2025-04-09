//
// Created by Yunjae on 2025-04-08.
//
#include <iostream>
#include <map>
#include <vector>
#include <queue>
using namespace std;

int main() {

    int N;
    cin >> N;

    vector<vector<int> > vec;

    for (int i = 0; i < N; i++) {
        vector<int> row(N);
        vec.push_back(row);
    }

    int K;
    cin >> K;

    for (int i = 0; i < K; i++) {
        int x, y;
        cin >> x >> y;
        vec[x - 1][y - 1] = 1;
    }

    int L;
    cin >> L;

    int dir = 1;

    deque<pair<int, int>> snake;
    snake.push_front(make_pair(0, 0));

    int answer = 0;

    map<int, char> direction;

    for (int i = 0; i < L; i++) {
        int n;
        char d;
        cin >> n >> d;
        direction[n] = d;
    }

    vec[0][0] = 2;

    while (true) {
        int h_x = snake[0].first;
        int h_y = snake[0].second;
        //뱀이 이동
        answer++;
        if (dir == 1 && h_y + 1 < N) {
            if (vec[h_x][h_y + 1] == 1) {
                vec[h_x][h_y + 1] = 2;
                snake.push_front(make_pair(h_x, h_y + 1));
            } else if(vec[h_x][h_y + 1] == 0){
                snake.push_front(make_pair(h_x, h_y + 1));
                vec[h_x][h_y + 1] = 2;
                vec[snake.back().first][snake.back().second] = 0;
                snake.pop_back();
            }
            else {
                break;
            }
        } else if (dir == 2 && h_x + 1 < N) {
            if (vec[h_x + 1][h_y] == 1) {
                vec[h_x + 1][h_y] = 2;
                snake.push_front(make_pair(h_x + 1, h_y));
            } else if(vec[h_x + 1][h_y] == 0){
                snake.push_front(make_pair(h_x + 1, h_y));
                vec[h_x + 1][h_y] = 2;
                vec[snake.back().first][snake.back().second] = 0;
                snake.pop_back();
            }
            else {
                break;
            }
           // snake = temp;
        } else if (dir == 3 && h_y - 1 >= 0) {
            if (vec[h_x][h_y - 1] == 1) {
                vec[h_x][h_y - 1] = 2;
                snake.push_front(make_pair(h_x, h_y - 1));
            } else if(vec[h_x][h_y - 1] == 0){
                snake.push_front(make_pair(h_x, h_y - 1));
                vec[h_x][h_y - 1] = 2;
                vec[snake.back().first][snake.back().second] = 0;
                snake.pop_back();
            }
            else {
                break;
            }
        } else if (dir == 0 && h_x - 1 >= 0) {
            if (vec[h_x - 1][h_y] == 1) {
                vec[h_x - 1][h_y] = 2;
                snake.push_front(make_pair(h_x - 1, h_y));
            } else if(vec[h_x - 1][h_y] == 0){
                snake.push_front(make_pair(h_x - 1, h_y));
                vec[h_x - 1][h_y] = 2;
                vec[snake.back().first][snake.back().second] = 0;
                snake.pop_back();
            }
            else {
                break;
            }
        } else {
            //벽에 부딪히는 순간
            break;
        }
        if(direction[answer] == 'D') dir ++;
        if(direction[answer] == 'L') dir --;
        if(dir < 0) dir += 4;
        dir %= 4;
    }
    cout << answer << '\n';
    return 0;
}