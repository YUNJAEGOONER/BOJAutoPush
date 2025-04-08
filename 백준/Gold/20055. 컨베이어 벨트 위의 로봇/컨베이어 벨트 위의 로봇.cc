//
// Created by Yunjae on 2025-04-08.
//
#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main() {
    int N, K;
    cin >> N >> K;
    int cnt = 0;

    vector<int> vec;
    for(int i = 0 ; i < 2 * N ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    map<int, int, greater<int>> robot; //idx, int(=1)

    int answer = 0;

    while(cnt < K) {
        answer ++;

        //rotate - belt
        vector<int> tmp(vec.size());
        for(int j = 0 ; j < vec.size() ; j++) {
            tmp[(j + 1) % vec.size()] = vec[j];
        }
        vec = tmp;

        //rotate - robot
        for(auto a : robot) {
            if(a.second != 0) {
                robot[a.first + 1] = 1;
                robot[a.first] = 0;
                if(a.first + 1 == N - 1) robot[a.first + 1] = 0;
            }
        }

        for(auto a : robot) {
            if(a.second != 0) {
                if(robot[a.first + 1] == 0 && vec[a.first + 1] >= 1) {
                    robot[a.first + 1] = 1;
                    robot[a.first] = 0;
                    vec[a.first + 1] -= 1;
                    if(vec[a.first + 1] == 0) cnt ++;
                    if(a.first + 1 == N - 1) robot[a.first + 1] = 0;
                }
            }
        }

        if(vec[0] != 0 && robot[0] == 0) {
            robot[0] = 1;
            vec[0] -= 1;
            if(vec[0] == 0) cnt ++;
        }
    }

    cout << answer << ' ';

    return 0;
}